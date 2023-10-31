package testrunner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.RecruitmentCandidateTab;
import pages.loginPage;
import setup.setup_OrangeHRM;

public class CandidateTab_TestRunner extends setup_OrangeHRM{
	
	RecruitmentCandidateTab recruitmentCandidateSearch;
	loginPage loginPageOrangeHRM;
	
	@Test(priority = 1,description ="Search candidate without filter")
	public void candidateSearch() {
		loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);
		String username = (String) jsonobject.get("username");
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch = new RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.candidateSearchWithoutFilter();
        String message = setup_OrangeHRM.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(message.contains("Records Found"));
        softAssert.assertAll();
	}
	@Test(priority = 2, description = "Search candidate with single dropdown filter")
    public void candidateSearchWithDropDownFilter(){
		loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);
		String username = (String) jsonobject.get("username");
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch = new RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.candidateSearchWithoutFilter();
        String message = setup_OrangeHRM.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(message.contains("Records Found"));
        softAssert.assertAll();
	}
	
	@Test(priority = 3, description = "Search candidate with inputTextBox filter")
    public void candidateSearchWithInputTextBoxFilter(){
		loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);
		String username = (String) jsonobject.get("username");
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch = new RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.candidateSearchWithInputTextBoxFilter();
	}
    @Test(priority = 4, description = "Reset Button on Candidate Page")
    public void candidateResetButton(){
    	loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);
		String username = (String) jsonobject.get("username");
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch = new RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.candidateResetButton();
        String message = setup_OrangeHRM.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        System.out.println(message);
        softAssert.assertTrue(message.contains("Records Found"));
        softAssert.assertAll();
    }	
    @Test(priority = 5, description = "All Candidates select")
    public void selectAllCandidatesInRecord() {
    	loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);
		String username = (String) jsonobject.get("username");
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch = new RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.selectAllCandidatesInRecord();
        String deleteBtnMessage = setup_OrangeHRM.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
        softAssert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
        String selectMessage = setup_OrangeHRM.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(selectMessage.contains("Selected"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-container')]/div[1]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")).click();
        String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(message.contains("Found"));
        softAssert.assertAll();
    }
    @Test(priority = 6, description = "Delete selected Candidate")
    public void deleteCandidateOnSingleCheckBoxSelect(){
    	loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);     
    	String username= (String) jsonobject.get("username");;
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch =new  RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.deleteCandidateOnSingleCheckBoxSelect();
   }
    @Test(priority = 7, description = "Multi selected records Delete Candidates")
    public void deleteCandidateMultiSelect(){
    	loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);     
    	String username= (String) jsonobject.get("username");;
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch =new  RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.deleteCandidateMultiSelect();
   }
    @Test(priority = 8, description = "Validating View Button")
    public void viewButton(){
    	loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);     
    	String username= (String) jsonobject.get("username");;
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch =new  RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.viewButton();
   }
    @Test(priority = 9, description = "Validating Delete Button")
    public void deleteButtomicon(){
    	loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);     
    	String username= (String) jsonobject.get("username");;
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch =new  RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.deleteButtonIcon();
   } 
    @Test(priority = 10, description = "Adding new candidate")
    public void addNewCandidate(){
    	loginPageOrangeHRM = new loginPage(setup_OrangeHRM.driver);     
    	String username= (String) jsonobject.get("username");;
        String password= (String) jsonobject.get("password");
        loginPageOrangeHRM.doLogin(username,password);
        recruitmentCandidateSearch =new  RecruitmentCandidateTab(setup_OrangeHRM.driver);
        recruitmentCandidateSearch.addNewCandidate();
   }
   
    
    
}
