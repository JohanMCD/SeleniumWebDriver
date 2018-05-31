package SystemRun;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import EventsControl.ReportResults;
import TestCases.DoExam;

public class System1 {
	WebDriver driver;
	ExtentReports logger;

	@BeforeTest
	public  void Start(){
		System.setProperty("webdriver.chrome.driver","C:/Selenium/chromedriver.exe");
			logger = ExtentReports.get(System1.class);
			logger.config().displayCallerClass(false);
			logger.init("C:\\Users\\japaricio\\Desktop\\Reports\\report.html ",true);
			logger.startTest("Start Website: https://www.w3schools.com/default.asp","  Inicial el negagador en: W3SCHOOLS.");
			try{
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.w3schools.com/default.asp"); 
				Boolean verify = ReportResults.VerificateTextScreen(driver, "class='w3schools-logo'", "w3schools");
				ReportResults.ValidateStep(verify, logger, "Sesion iniciada correctamente", true);
			}catch(Exception e){
				logger.log(LogStatus.FATAL, e.getMessage());
			}
			logger.endTest();
	}
	

	///////////////////TEST SUITES//////////////////////

	@Test
	public void case1(){
	  DoExam.Execute(logger,driver);
     // DoExam.Execute(driver);	
	}
}
