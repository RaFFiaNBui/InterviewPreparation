package thrid;

import java.util.Iterator;

public class MyList<E> implements Iterable<E> {
    private Node<E> node = null;
    private int counter = 0;

    public MyList() {
        node = new Node<>();
    }

    public int size() {
        return counter;
    }

    public void add(E element) {
        if (counter == 0) {
            node.set(element);
        } else {
            node.add(element);
        }
        counter++;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(node);
    }

    private class Node<E> {
        private E element;
        private Node<E> next = null;
        private Node<E> prev = null;

        Node() {}
        Node(E element) {
            set(element);
        }

        void set(E element) {
            this.element = element;
        }

        void add(E element) {
            if (isNext()) {
                next.add(element);
            } else {
                Node<E> temp = this;
                next = new Node<>(element);
                next.setPrev(temp);
            }
        }

        E get() {
            return element;
        }

        boolean isNext() {
            return next != null;
        }

        void setPrev (Node<E> node) {
            prev = node;
        }
    }
}
