package com.assessment;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import cucumber.api.java.gl.E;
import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.*;

import static org.junit.Assert.*;

public class testSteps {
    private WebDriver driver;
    private ExtentReports report;
    private ExtentTest test;
    private boolean cond;
    private loginPage login;
    private dashboard dash;
    private addEmployee add;
    private createLogin crLogin;
    private details ds;
    private searchPage search;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", constant.driver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        report = new ExtentReports(constant.report, true);
    }
    @After
    public void tearDown(){
        report.flush();
        //driver.quit();

    }
    @Given("^the login page$")
    public void the_login_page(){
        test = report.startTest("OrangeHRM");
        driver.navigate().to(constant.URL);
        test.log(LogStatus.INFO, "Navigating to the login page...");
        login = new loginPage(driver);
    }

    @When("^I login$")
    public void i_login(){
        test.log(LogStatus.INFO, "Entering username and password");
        login.loginTask();
        cond = login.checkURL();
        if(cond) test.log(LogStatus.PASS, "Login was successful");
        else test.log(LogStatus.FAIL, "Login was unsuccessful");
        assertTrue(cond);
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab(){
        dash = new dashboard(driver);
        dash.clickPIM();
        test.log(LogStatus.INFO, "Clicking the PIM tab...");
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab(){
        test.log(LogStatus.INFO, "Clicking the Add Employee Tab...");
        dash.clickEmployee();
        cond = dash.checkURL();
        if(cond) test.log(LogStatus.PASS, "The Add Employee page is displayed");
        else test.log(LogStatus.FAIL, "The page has not been displayed");
        assertTrue(cond);
    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly(){
        add = new addEmployee(driver);
        add.enterDetails();
        test.log(LogStatus.INFO, "Entering employee details...");
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button(){
        test.log(LogStatus.INFO, "Choosing to create login details...");
        add.selectLogin();
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() {
        test.log(LogStatus.INFO, "Filling out login details...");
        crLogin = new createLogin(driver);
        crLogin.enterDetails();
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws Exception {
        test.log(LogStatus.INFO, "Clicking the save button...");
        Thread.sleep(6000);//for some reason it doesn't work without this
        crLogin.pressSave();
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws Exception {
        ds = new details(driver);
        test.log(LogStatus.INFO, "Navigating to the search page...");
        ds.search();
        test.log(LogStatus.INFO, "Searching for the created user...");
        search = new searchPage(driver);
        search.search();
        cond = search.checkSearch();
        if(cond) test.log(LogStatus.PASS, "Search was successful");
        else test.log(LogStatus.PASS, "Search was unsuccessful");
        assertTrue(cond);
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection(){
        report.endTest(test);
    }

}
