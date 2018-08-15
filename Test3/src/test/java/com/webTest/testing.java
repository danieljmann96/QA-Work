package com.webTest;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.*;

import java.util.concurrent.TimeUnit;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class testing {
    public static ExtentReports report;
    public ExtentTest test;
    private WebDriver driver;
    @BeforeClass
    public static void setUpClass(){
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\autotest\\BasicReport.html", true);
    }
    @AfterClass
    public static void tearDownClass(){
        report.flush();
    }
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Development\\chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void draggable(){
        test = report.startTest("Draggable");
        test.log(LogStatus.INFO, "Browser started");
        driver.manage().window().maximize();
        driver.navigate().to("http://demoqa.com/draggable/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        draggable page = new draggable(driver);
        boolean cond = page.defaultFunctionality(200, 400);
        if(cond) test.log(LogStatus.PASS, "Element has moved");
        else test.log(LogStatus.FAIL, "Element has not moved");
        report.endTest(test);
        assertTrue(cond);
    }
    @Test
    public void droppable(){
        test = report.startTest("Droppable");
        test.log(LogStatus.INFO, "Browser started");
        driver.manage().window().maximize();
        driver.navigate().to("http://demoqa.com/droppable/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        droppable page = new droppable(driver);
        boolean cond = page.defaultFunctionality();
        if(cond) test.log(LogStatus.PASS, "Colour changed after dropping");
        else test.log(LogStatus.FAIL, "Colour has stayed the same after dropping");
        report.endTest(test);
        assertTrue(cond);
    }
    @Test
    public void resizable(){
        test = report.startTest("Resizable");
        test.log(LogStatus.INFO, "Browser started");
        driver.manage().window().maximize();
        driver.navigate().to("http://demoqa.com/resizable/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        resizable page = new resizable(driver);
        boolean cond = page.defaultFunctionality(200, 400);
        if(cond) test.log(LogStatus.PASS, "Element has resized");
        else test.log(LogStatus.FAIL, "Element has not resized");
        report.endTest(test);
        assertTrue(cond);
    }
    @Test
    public void selectable(){
        test = report.startTest("Selectable");
        test.log(LogStatus.INFO, "Browser started");
        driver.manage().window().maximize();
        driver.navigate().to("http://demoqa.com/selectable/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        selectable page = new selectable(driver);
        boolean cond = page.df1(0,2,3,5);
        if(cond) test.log(LogStatus.PASS, "Elements have been selected and changed colour");
        else test.log(LogStatus.FAIL, "Elements haven't been selected");
        report.endTest(test);
        assertTrue(cond);
    }
}
