package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	// Return a WebDriver object
	public static WebDriver open(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdrver.chrome.driver", "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\chromedriver.exe");
			return new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdrver.gecko.driver", "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\geckodriver.exe");
			return new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdrver.ie.driver", "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		} else {
			System.setProperty("webdrver.chrome.driver", "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}
