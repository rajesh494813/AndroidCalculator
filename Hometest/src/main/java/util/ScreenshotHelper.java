package util;

import base.*;
import java.io.*;
import org.openqa.selenium.*;

public class ScreenshotHelper extends BaseTest
{
	
	// To take screenshot on failure of test
	
    public static void TakeScreenshot() {
        final TakesScreenshot ts = (TakesScreenshot)ScreenshotHelper.driver;
        ScreenshotHelper.source = (File)ts.getScreenshotAs(OutputType.FILE);
    }
}