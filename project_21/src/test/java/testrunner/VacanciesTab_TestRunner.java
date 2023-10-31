package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.RecruitmentCandidateTab;
import pages.RecruitmentVacanciesTab;
import setup.setup_OrangeHRM;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VacanciesTab_TestRunner extends setup_OrangeHRM {
	
	RecruitmentVacanciesTab vacanciesSearch;
	loginPage LoginPage;
	
	@Test(priority = 1, description ="Search vacancies without filter")
    public void vacanciesSearch() {
		LoginPage = new loginPage(setup_OrangeHRM.driver);
		String username = (String) jsonobject.get("username");
		String password = (String) jsonobject.get("password");
		LoginPage.doLogin(username, password);
		vacanciesSearch = new RecruitmentVacanciesTab(setup_OrangeHRM.driver);
		vacanciesSearch.vacanciesSearchWithoutFilter();
		String message = setup_OrangeHRM.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(message.contains("Records Found"));
        softAssert.assertAll();
	}
	
	 @Test(priority = 2, description ="Search candidate with single filter")
	 public void vacanciesSearchWithSingleFilter(){
		 LoginPage = new loginPage(setup_OrangeHRM.driver);
		 String username = (String) jsonobject.get("username");
		 String password = (String) jsonobject.get("password");
		 LoginPage.doLogin(username, password);
		 vacanciesSearch = new RecruitmentVacanciesTab(setup_OrangeHRM.driver);
		 vacanciesSearch.vacanciesSearchWithSingleFilter();
		 String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
	     System.out.println(message);
	     softAssert.assertTrue(message.contains("Found"));
	     softAssert.assertAll();
	    }
	 
	 @Test(priority = 3, description ="search with multiFilter")
	 public void vacanciesSearchWithMultiFilter(){
		 LoginPage = new loginPage(setup_OrangeHRM.driver);
		 String username = (String) jsonobject.get("username");
		 String password = (String) jsonobject.get("password");
		 LoginPage.doLogin(username, password);
		 vacanciesSearch = new RecruitmentVacanciesTab(setup_OrangeHRM.driver);
		 vacanciesSearch.vacanciesSearchWithMultiFilter();
		 String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
	     softAssert.assertTrue(message.contains("Found"));
	     softAssert.assertAll();
	    }
	 
	 @Test(priority = 4, description ="Reset Button on Vacancies Page")
	 public void vacanciesResetButton(){
		 LoginPage = new loginPage(setup_OrangeHRM.driver);
		 String username = (String) jsonobject.get("username");
		 String password = (String) jsonobject.get("password");
		 LoginPage.doLogin(username, password);
		 vacanciesSearch = new RecruitmentVacanciesTab(setup_OrangeHRM.driver);
		 vacanciesSearch.vacanciesResetButton();
		 String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
	     softAssert.assertTrue(message.contains("Found"));
	     softAssert.assertAll();
	    }
	 
	 @Test(priority = 5, description ="Select all vacancy record")
	  public void vacanciesSelectAllRecords(){
		 LoginPage = new loginPage(setup_OrangeHRM.driver);
		 String username = (String) jsonobject.get("username");
		 String password = (String) jsonobject.get("password");
		 LoginPage.doLogin(username, password);
		 vacanciesSearch = new RecruitmentVacanciesTab(setup_OrangeHRM.driver);
	     vacanciesSearch.vacanciesSelectAllRecords();
	     String deleteBtnMessage = setup_OrangeHRM.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
	     softAssert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
	     String selectMessage = setup_OrangeHRM.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
	     softAssert.assertTrue(selectMessage.contains("Selected"));
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     driver.findElement(By.xpath("//div[contains(@class,'orangehrm-container')]/div[1]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")).click();
	     String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
	     System.out.println(message);
	     softAssert.assertTrue(message.contains("Found"));
	     softAssert.assertAll();
	    }
	 
	 @Test(priority = 6, description = "Single selected Vacancy")
	 public void vacanciesSingleSelect(){
	      LoginPage = new loginPage(setup_OrangeHRM.driver);
	      String username = (String) jsonobject.get("username");
	      String password = (String) jsonobject.get("password");
	      LoginPage.doLogin(username, password);
	      vacanciesSearch =new RecruitmentVacanciesTab(driver);
	      vacanciesSearch.vacanciesSingleSelect();
	      String deleteBtnMessage = setup_OrangeHRM.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
	      System.out.println(deleteBtnMessage);
	      softAssert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
	      String selectMessage = setup_OrangeHRM.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
	      softAssert.assertTrue(selectMessage.contains("Selected"));
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).click();
	      String confirmationMsg = driver.findElement(By.xpath("//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[2]/p[contains(@class,'oxd-text oxd-text--p oxd-text--card-body')]")).getText();
	      System.out.println(confirmationMsg);
	      softAssert.assertTrue(confirmationMsg.contains("permanently deleted"));
	      softAssert.assertAll();
	    }
	 
	 @Test(priority = 7, description = "Multi selected records Delete Candidates")
	 public void deleteCandidateMultiSelect(){
		  LoginPage = new loginPage(setup_OrangeHRM.driver);
	      String username = (String) jsonobject.get("username");
	      String password = (String) jsonobject.get("password");
	      LoginPage.doLogin(username, password);
	      vacanciesSearch =new RecruitmentVacanciesTab(driver);
	      vacanciesSearch.deleteMultiSelectVacancies();
	      softAssert.assertAll();
	 }
	 
	 @Test(priority = 8, description = "Validating Delete Icon")
	 public void deleteIconVacancies(){
		  LoginPage = new loginPage(setup_OrangeHRM.driver);
	      String username = (String) jsonobject.get("username");
	      String password = (String) jsonobject.get("password");
	      LoginPage.doLogin(username, password);
	      vacanciesSearch =new RecruitmentVacanciesTab(driver);
	      vacanciesSearch.deleteIconOfVacancies();
	      softAssert.assertAll();
	 }
	    
	 @Test(priority = 9, description = "Validating Edit Icon")
	 public void editIconOfVacancies(){
		  LoginPage = new loginPage(setup_OrangeHRM.driver);
	      String username = (String) jsonobject.get("username");
	      String password = (String) jsonobject.get("password");
	      LoginPage.doLogin(username, password);
	      vacanciesSearch =new RecruitmentVacanciesTab(driver);
	      vacanciesSearch.editIconOfVacancies();
	      softAssert.assertAll();
	 }
	 
	 @Test(priority = 10, description = "Adding new Vacancy")
	 public void addNewVacancy(){
		  LoginPage = new loginPage(setup_OrangeHRM.driver);
	      String username = (String) jsonobject.get("username");
	      String password = (String) jsonobject.get("password");
	      LoginPage.doLogin(username, password);
	      vacanciesSearch =new RecruitmentVacanciesTab(driver);
	      vacanciesSearch.addNewVacancy();
	      softAssert.assertAll();
	 }
}
