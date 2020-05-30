package ru.samarin.mywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Arrays;

import ru.siamarin.mywdget.R;

public class MyWidget extends AppWidgetProvider {

    public static final String TAG = "AppWidgetProvider";
    public static final String ACTION_WIDGET_RECEIVER = "ActionReceiverWidget";

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d(TAG, "onEnabled: ");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.d(TAG, "onUpdate: " + Arrays.toString(appWidgetIds));

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);

        //Подготавливаем Intent для Broadcast
        Intent intent = new Intent(context, MyWidget.class);
        intent.setAction(ACTION_WIDGET_RECEIVER);
        intent.putExtra("message", "It Works!");
        //создаем наше событие
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        //регистрируем наше событие
        remoteViews.setOnClickPendingIntent(R.id.btn_widget, pendingIntent);
        //обновляем виджет
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //Ловим наш Broadcast, проверяем и выводим сообщение
        String action = intent.getAction();
        if (ACTION_WIDGET_RECEIVER.equals(action)) {
            String message = intent.getStringExtra("message");
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onReceive: Кнопка нажата");
        }
        super.onReceive(context, intent);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.d(TAG, "onDeleted: " + Arrays.toString(appWidgetIds));
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.d(TAG, "onDisabled: ");
    }
}
