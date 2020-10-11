package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

public class BaseFunctions {
    public static final int TIME_OUT = 25;
    public static WebDriver driver = BrowserSetUp.driver;

    public static void click(By locator, int ...seconds){

        int time = (seconds.length==0) ? TIME_OUT : seconds[0];
        try{
            WebDriverWait wait = new WebDriverWait(driver, time);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            fluentWait(locator, time);
            element.click();
        }catch(Exception e){
//            LoggerUtil.log(e.getMessage());
        }


    }

    public static void type(By locator, String value){

        try{
            WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            setTimeOut(TIME_OUT);
            element.click();
            element.click();
            element.click();
            element.sendKeys(value);
        }catch(NoSuchElementException e){
//            LoggerUtil.log(e.getMessage());
        }

    }

    public static boolean waitForElementNotVisible(WebDriver driver, String elementXPath, int timeOutInSeconds) {
        try {
            (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(By
                    .xpath(elementXPath)));
            return true;
        } catch (TimeoutException e) {
            LoggerUtil.log(e.getMessage());
            return false;
        }
    }

    public static boolean verifyElementPresent(By locator){

        boolean status=false;
        try{
            if(driver.findElement(locator)!=null)
            {
                status=true;

            }

        }
        catch(Exception e)
        {
            LoggerUtil.log(e.getMessage());
            status=false;
        }
        return status;


    }
    public static void select(By locator, String Value){
        try{
            Select drpMarkingType = new Select(driver.findElement(locator));
            waitTillElementLoaded(locator, TIME_OUT);
            drpMarkingType.selectByVisibleText(Value);
        }catch(Exception e){
            LoggerUtil.log(e.getMessage());
        }

    }

    public static void selectByIndex(By locator, Integer Index){
        try{
            Select drpMarkingType = new Select(driver.findElement(locator));
            drpMarkingType.selectByIndex(Index);
        }catch(NoSuchElementException e){
            LoggerUtil.log(e.getMessage());
        }
    }

    public static void clear(By locator){
        try{
            driver.findElement(locator).clear();
        }catch(NoSuchElementException e){
            LoggerUtil.log(e.getMessage());
        }
    }
    public static void clear(WebElement element){
        try{
            element.clear();
        }catch(NoSuchElementException e){
            LoggerUtil.log(e.getMessage());
        }
    }

    public static String getText(By locator){
        String text = "";

        try{
            waitTillElementLoaded(locator,TIME_OUT);
            text = driver.findElement(locator).getText();

        }catch(NoSuchElementException e){
            LoggerUtil.log(e.getMessage());
        }
        return text;
    }

    public static void clickEnter(By locator){
        try{
            driver.findElement(locator).sendKeys(Keys.ENTER);
        }catch(NoSuchElementException e){
            LoggerUtil.log(e.getMessage());
        }
    }

    public static void javascriptClick(By by) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", findElement(by));
        }catch (Exception e){
            LoggerUtil.log(e.getMessage());
        }
    }

    public static boolean isDisplayed(By by, long timeOut) {
        try {
            setTimeOut(timeOut);
            findElement(by, timeOut);
//			setTimeOut(TIME_OUT);
            return true;
        } catch (Exception e) {
            LoggerUtil.log(e.getMessage());
            return false;
        }
    }

    public static boolean isDisplayed(By by) {
        try {
            setTimeOut(TIME_OUT);
            findElement(by, TIME_OUT);
//			setTimeOut(TIME_OUT);
            return true;
        } catch (Exception e) {
            LoggerUtil.log(e.getMessage());
            return false;
        }
    }

    public static void clickBack(){
        try{
            driver.navigate().back();
        } catch (Exception e){
            LoggerUtil.log(e.getMessage());
        }
    }

    public static void fluentWait(By locator, int interval){

        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(interval, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public static void setTimeOut(long timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(timeoutInSeconds, TimeUnit.SECONDS);
    }

    public static WebElement waitTillElementLoaded(By by, long timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement findElement(By by) {
        try {
            waitTillElementLoaded(by,TIME_OUT);
        }catch (Exception e){
            LoggerUtil.log(e.getMessage());
        }
        return driver.findElement(by);
    }

    public static WebElement findElement(By by, long timeout) {
        try {
            waitTillElementLoaded(by,timeout);
        }catch (Exception e){
            LoggerUtil.log(e.getMessage());
        }
        return driver.findElement(by);
    }

}


