package EventsControl;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;

//import com.relevantcodes.extentreports.ExtentReports;

public class EventsBehavior {
	
		//Set text field 
		public static boolean SetTextByIdXpath(WebDriver driver, String property, String text) {	
			WebDriverWait wait = new WebDriverWait(driver, 1);
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
				driver.findElement(By.xpath(Properties(property))).sendKeys(text); return true;
			}catch(Exception e1){ return false;}
		}
	
		//Click to button
		public static boolean ClickToButton(WebDriver driver, String property){
			WebDriverWait wait = new WebDriverWait(driver, 2);
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
				driver.findElement(By.xpath(Properties(property))).click();	return true;
			}catch(Exception e2){
				return false;
			}
		}
		
		//DobleClick to button
		public static boolean DobleClickToButton(WebDriver driver, String property){
			WebDriverWait wait = new WebDriverWait(driver, 2);
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
				driver.findElement(By.xpath(Properties(property))).click();	
				driver.findElement(By.xpath(Properties(property))).click();
				return true;
			}catch(Exception e2){
				return false;
			}
		}
	
		//Click to Links and short test Link
		public static boolean ClickToLink(WebDriver driver, ExtentReports logger, String link) {		
			WebDriverWait wait = new WebDriverWait(driver, 2);
			try {	
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(link)));
				driver.findElement(By.linkText(link)).click();	return true;
			} catch (Exception e) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(link)));
				driver.findElement(By.partialLinkText(link)).click();	return true;
			} catch (Exception e1) {return false;}
		}
	}

		//Select dropdown values text
		public static boolean SelectValueDropdownText(WebDriver driver, String property, String text){
			try {	
				Select dropdown = new Select(driver.findElement(By.xpath(Properties(property))));
				dropdown.selectByVisibleText(text);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	
		//Select dropdown values dimension 
		public static boolean SelectValueDropdown(WebDriver driver, String property, int index){
			try {	
				Select dropdown = new Select(driver.findElement(By.xpath(Properties(property))));
				dropdown.selectByIndex(index); return true;
			} catch (Exception e) {
				return false;
			}
		}
	
		//wait a few sec
		public static void WaitForSec(WebDriver driver, int segundos){
			synchronized(driver){
				try {
		            driver.wait(segundos * 1000);
		         } catch (InterruptedException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		         }
			}
		}
	 
		 //Click to check box
		 public static boolean ClickToCheckBox(WebDriver driver, String property){
			 WebDriverWait wait = new WebDriverWait(driver, 2);
			 try{
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
				 if(!driver.findElement(By.xpath(Properties(property))).isSelected()){
				      driver.findElement(By.xpath(Properties(property))).click(); return true;
				 }
			 }catch (Exception e) {
				return false;
			 }
			return false;
		 }
		 
		 //search property
		 public static String Properties(String properties){
			 String property =".//*[@"+properties+"]";
			 return property;
		 }
		  
		 public static WebElement GetObject(WebDriver driver,String property){
			 return driver.findElement(By.xpath(Properties(property)));
		 }
		 
		 public static boolean SelectRadioButton(WebDriver driver, String property, String text){
			 WebDriverWait wait = new WebDriverWait(driver, 2);
			 try{
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
				 List<WebElement>radioButton = driver.findElements(By.xpath(Properties(property)));	 
				 for(int i=0;i<radioButton.size();i++){
					if(radioButton.get(i).getText().equals(text)){
						radioButton.get(i).click();
						return true;
					}
				 } 
			 }catch (Exception e) {
					return false;
			 }
			 return false;
		 }
		 
		 public static boolean SelectRadioButton(WebDriver driver, String property){
			 WebDriverWait wait = new WebDriverWait(driver, 2);
			 try{
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
				 if(!driver.findElement(By.xpath(Properties(property))).isSelected()){
				      driver.findElement(By.xpath(Properties(property))).click(); return true;
				 }  
			 }catch (Exception e) {
					return false;
			 }
			 return false;
		 }
		 
		//search property
		 public static boolean Exist(WebDriver driver,String property){
			 try {
				 if(driver.findElement(By.xpath(Properties(property))).isEnabled()){
					 return true; 
				 }
			} catch (Exception e) {
				return false;
			}
			 return false;
		 }
		 
}

