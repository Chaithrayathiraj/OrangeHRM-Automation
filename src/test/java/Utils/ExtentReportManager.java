package Utils;



import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = "D:\\30 May 2025\\J Drive\\eclipse-workspace\\OrangeHRM\\test-output\\ExtentReport.html";
            
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "OrangeHRM Automation");
            extent.setSystemInfo("Tester", "Chaithra Yathiraj");
            System.out.println("ExtentReport Path: " + reportPath);

        }
        return extent;
    }

}