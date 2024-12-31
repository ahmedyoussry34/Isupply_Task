package utilis;

import org.openqa.selenium.By;

public class UIlocators {

    public static By SEARCH_FIELD = By.id("APjFqb");
    public static By FILE_UPLOAD = By.xpath("//a[contains(text(),'File Upload')]");
    public static By RESULT_TEXT = By.xpath("((//h3[not(ancestor::div[@class='g'])])[3]/ancestor::*[5]/following-sibling::*//span)[3]");
    public static By DESCRIPTION_OF_RESULT = By.xpath("(//h3[not(ancestor::div[@class='g'])])[3]");
    public static By DYNAMIC_LOADING = By.xpath("//a[contains(text(),'Dynamic Loading')]");
    public static By EXAMPLE2 = By.xpath("//*[contains(text(),'Example 2')]");
    public static By START_BUTTON = By.xpath("//button[text()='Start']");
    public static By TEXT_AFTER_LOADING = By.xpath("//*[@id='finish']/*");
    public static By CHOOSE_FILE = By.id("file-upload");
    public static By SUBMIT_BUTTON = By.id("file-submit");
    public static By SUCCESS_MESSAGE = By.xpath("//*[contains(text(), 'File Uploaded!')]");
    public static By UPLOADED_FILE_NAME = By.id("uploaded-files");




}
