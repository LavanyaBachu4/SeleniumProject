package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static void takeScreenShot(WebDriver driver, String name){
        try {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File ss = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("./Screenshots/"+name+".png");
            FileUtils.copyFile(ss, dest);
            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static String takeScreenShotForReport(WebDriver driver){
            TakesScreenshot ts = (TakesScreenshot)driver;
            String screenshot = ts.getScreenshotAs(OutputType.BASE64);
            return screenshot;
    }

    public static String getCurrentDateTime(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
        String date = dateFormat.format(currentDate);
        return date;
    }
}
