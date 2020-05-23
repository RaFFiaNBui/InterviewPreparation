import java.util.*;
class Report{
	private List<ReportItem> items;	// Отчетные данные
	private PrintDisplayReport printDisplayReport;

	public Report(PrintDisplayReport printDisplayReport) {
		this.printDisplayReport = printDisplayReport;
	}

	// расчет отчетных данных
	public void calculate(){
		items =  new ArrayList<ReportItem>();
		items.add(new ReportItem("First", (float)5));
		items.add(new ReportItem("Second", (float)6));
	}

	public void setPrintDisplayReport(PrintDisplayReport printDisplayReport) {
		this.printDisplayReport = printDisplayReport;
	}

	public void output(){
		printDisplayReport.output(items);
	}
}