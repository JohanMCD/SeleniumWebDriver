package TestCases;

import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import EventsControl.EventsBehavior;
import EventsControl.ReportResults;

public class DoExam {
static String button_html ="href='/html/default.asp'";
static String button_examples ="id='topnavbtn_examples'";	
static String button_quiz ="href='/quiztest/quiztest.asp?Qtest=HTML'";
static String test_result ="class='w3-padding w3-light-grey w3-large'";
	
	
	public static void Execute(ExtentReports logger, WebDriver driver){
		logger.startTest("Tomar quiz de html"," Responderemos las 40 preguntas de este Quiz");

		//Click Learn HTML
		EventsBehavior.ClickToButton(driver, button_html);
		
		//Click EXAMPLES
		EventsBehavior.ClickToButton(driver, button_examples);
		
		//Click HTML Quiz
		EventsBehavior.ClickToButton(driver, button_quiz);
	
		while(EventsBehavior.Exist(driver, "id='1'")){
			int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
			if(EventsBehavior.Exist(driver, "id='"+randomNum+"'")){
				EventsBehavior.SelectRadioButton(driver, "id='"+randomNum+"'");
				EventsBehavior.ClickToButton(driver, "type='submit'");
			} else {
				randomNum--;
				if(EventsBehavior.Exist(driver, "id='"+randomNum+"'")){
					EventsBehavior.SelectRadioButton(driver, "id='"+randomNum+"'");
					EventsBehavior.ClickToButton(driver, "type='submit'");
				}else {
					randomNum--;
					EventsBehavior.SelectRadioButton(driver, "id='"+randomNum+"'");
					EventsBehavior.ClickToButton(driver, "type='submit'");
				}	
			}
		}
		
		String sCadena = EventsBehavior.GetObject(driver,test_result).getText();
		int result = Integer.parseInt(sCadena.charAt(17)+""+sCadena.charAt(18));
		
		if(result>50){
			ReportResults.ValidateStep(true, logger, "El examen paso satisfactoriamiente");
		}else {
			ReportResults.ValidateStep(false, logger, "Examen reprobado ");
		}
		logger.endTest();
	}
}
