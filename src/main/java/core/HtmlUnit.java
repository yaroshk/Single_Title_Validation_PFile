package core;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnit {
	public static void main(String[] args)  {

		WebDriver driver = new HtmlUnitDriver();
		((HtmlUnitDriver) driver).setJavascriptEnabled(true); // Version 1.2 :: HtmlUnit

		String test_case_id = null;
		String browser = "HtmlUnit";
		String url = null;
		String title_expected = null;
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("Test.properties"));
			
				test_case_id = properties.getProperty("Text_case_id");
				url = properties.getProperty("url");
				title_expected = properties.getProperty("title_expected");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();

		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + test_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Browser: \t\t" + browser);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + test_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Browser: \t\t\t" + browser);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
		
		driver.quit();
	}
}
