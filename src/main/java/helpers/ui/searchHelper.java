package helpers.ui;

import org.testng.Assert;
import utilis.SystemProperties;
import utilis.UIlocators;
import utilis.seleniumActions;

import static utilis.SystemProperties.softAssert;

public class searchHelper {

    public void Search(String key, String searchTerm){
    seleniumActions action = new seleniumActions(key);
    action.navigateTo(SystemProperties.getBaseWebsiteURL(),true);
    action.sendKeys(UIlocators.SEARCH_FIELD, searchTerm,true);
    action.sendEnterKey(UIlocators.SEARCH_FIELD,true);
    String S2 = action.getText(UIlocators.DESCRIPTION_OF_RESULT, true);
    String S = action.getText(UIlocators.RESULT_TEXT, true);
    System.out.println("result is " + S);
    System.out.println("result is " + S2);
    Assert.assertEquals(S,"What is Selenium WebDriver?","result does not have What is Selenium WebDriver?");
    Assert.assertEquals(S2,"What is Selenium WebDriver?","result does not have What is Selenium WebDriver?");
    }
}
