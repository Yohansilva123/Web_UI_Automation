package pages.samplePages;

import org.openqa.selenium.By;
import utils.BaseFunctions;

public class SamplePage extends BaseFunctions {

    private static final By jacplusUseNameId = By.id("email");
    private static final By jacplusCredNextId = By.id("idpLogin");
    private static final By jacplusPasswordId = By.id("password");
    private static final By jacplusSubmitId = By.id("submit");
    private static final By jacplusBookShelf = By.xpath("//*[text()= 'Welcome to your bookshelf']");

    public static void enterUserName(String userName){
        type(jacplusUseNameId, userName);
    }

    public static void clickNext(){
        click(jacplusCredNextId);
    }

    public static void enterPassword(String password){
        type(jacplusPasswordId, password);
    }

    public static void clickNSubmit(){
        click(jacplusSubmitId);
    }

    public static Boolean isBookshelfDisplayed(){
        return isDisplayed(jacplusBookShelf);
    }
}
