package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static ExtentReports extent;

    public static ExtentReports getInstance(){
        if (extent==null){
            extent = createInstance();
        }
        return extent;
    }

    public static ExtentReports createInstance(){
        String path = "./reports/AutomationReport_"+Utility.getCurrentDateTime()+".html";
        ExtentSparkReporter sparkReport = new ExtentSparkReporter(path);
        sparkReport.config().setReportName("Test Report");
        sparkReport.config().setDocumentTitle(" Sprint n");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReport);
        return extent;
    }
}
