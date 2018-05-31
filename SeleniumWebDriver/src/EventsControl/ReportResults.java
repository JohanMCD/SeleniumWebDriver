package EventsControl;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ReportResults {
	
	
	//Validate the step and return result
	public static void ValidateStep(boolean verify, ExtentReports logger, String coments, boolean validate){
		if(verify){
			if (validate){
				logger.log(LogStatus.PASS, coments,"Accion Done");
				
			}else {
				logger.log(LogStatus.FAIL, coments," Not Done");
				CreatePrintScreen(logger);
			}
		} else if(!verify){
			logger.log(LogStatus.FAIL, coments," Not Done");
			CreatePrintScreen(logger);
		}else{
			logger.log(LogStatus.SKIP, coments," Not RUN");
		}
	} 
	
	//Validate the step and return result
		public static void ValidateStep(boolean verify, ExtentReports logger, String coments){
			if(verify){
				logger.log(LogStatus.PASS, coments,"Accion Done");
			} else if(!verify){
				logger.log(LogStatus.FAIL, coments," Not Done");
				CreatePrintScreen(logger);
			}else{
				logger.log(LogStatus.SKIP, coments," Not RUN");
			}
		} 
		
	
	public static boolean VerificateTextLink(WebDriver driver,  String obj) {		
		WebDriverWait wait = new WebDriverWait(driver, 1);
		try {	
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(obj)));
			driver.findElement(By.linkText(obj));return true;
		} catch (Exception e) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(obj)));
				driver.findElement(By.partialLinkText(obj));return true;
			} catch (Exception e1) {return false;}
		}
	}
	
	
	public static boolean VerificateTextScreen(WebDriver driver,String Property, String Text){
		WebDriverWait wait = new WebDriverWait(driver,2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@"+Property+"]")));
			if(driver.findElement(By.xpath(".//*[@"+Property+"]")).getText().contains(Text))
			return true;
		} catch (Exception e){ return false;}	
		return false;
	}
	
	
	private static void CreatePrintScreen(ExtentReports logger){
		 BufferedImage pantalla=null;
		 try {
			Robot robot = new Robot();
			pantalla = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			File file = new File("C:/Users/japaricio/Desktop/Reports/captura.png");
			ImageIO.write(pantalla, "jpg", file);
			
			logger.attachScreenshot("C:/Users/japaricio/Desktop/Reports/captura.png");
			
		} catch (Exception e) {
		   e.printStackTrace();
		}	
	}
	
	
}
