package functions;

import pages.samplePages.SamplePage;

public class SampleFunction {

    public static void loginToBookshelf(String userName, String password){
        SamplePage.enterUserName(userName);
        SamplePage.clickNext();
        SamplePage.enterPassword(password);
        SamplePage.clickNSubmit();
    }

    public static boolean isBookshelfDisplayed(){
        return SamplePage.isBookshelfDisplayed();
    }

}
