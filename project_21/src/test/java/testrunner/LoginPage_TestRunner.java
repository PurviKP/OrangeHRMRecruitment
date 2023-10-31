package testrunner;

import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import pages.loginPage;
import setup.setup_OrangeHRM;

public class LoginPage_TestRunner extends setup_OrangeHRM {
	loginPage LoginPage;
	
	@Test(priority = 1, description = "user login with valid Credential")
	public void doLogin() {
		LoginPage = new loginPage(driver);
		String username = (String) jsonobject.get("username");
		String password = (String) jsonobject.get("password");
		LoginPage.doLogin(username, password);
        String message = driver.findElement(By.tagName("h6")).getText();
        softAssert.assertEquals("Dashboard",message);
        softAssert.assertAll();
		}
	
	@Test(priority = 2,description = "User do Login with invalid credential")
	public void doLogInWithInvalidCreds() {
		LoginPage = new loginPage(driver);
		String message_actual = LoginPage.doLogInWithInvalidCreds("abc","abc123");
		String message_expected = "Invalid credentials";
		softAssert.assertTrue(message_actual.contains(message_expected));
		softAssert.assertAll();
	}
	@Test(priority = 3, description = "User dologin with valid username and Invalid password")
	public void doLogInWithInvalidpassword() {
		LoginPage = new loginPage(driver);
		String message_actual = LoginPage.doLogInWithInvalidCreds("admin","abc123");
		String message_expected = "Invalid credentials";
		softAssert.assertTrue(message_actual.contains(message_expected));
		softAssert.assertAll();
	}
	@Test(priority = 4, description = "User doLogin Without Credentials")
	public void doLogInWithoutCreds() {
		LoginPage = new loginPage(driver);
		String message_actual = LoginPage.doLogInWithoutCreds("","");
		String message_expected = "Required";
		softAssert.assertTrue(message_actual.contains(message_expected));
		softAssert.assertAll();
	}
	@Test(priority = 5, description = "User login with valid Credential")
	public void doLogout() {
		LoginPage = new loginPage(driver);
		String username = (String) jsonobject.get("username");
		String password = (String) jsonobject.get("password");
		LoginPage.doLogout(username, password);
	}
}
