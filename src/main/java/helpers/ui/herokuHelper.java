package helpers.ui;

import org.testng.Assert;
import utilis.SystemProperties;
import utilis.UIlocators;
import utilis.seleniumActions;

import java.nio.file.Paths;


public class herokuHelper {

    public void fileUpload(String key){
        seleniumActions action = new seleniumActions(key);
        String filePath = Paths.get("src", "test", "resources", "task photo.jpg").toAbsolutePath().toString();
        action.navigateTo(SystemProperties.getBaseWebsiteURL(),true);
        action.click(UIlocators.FILE_UPLOAD,true);
        action.sendKeys(UIlocators.CHOOSE_FILE, filePath,true);
        action.click(UIlocators.SUBMIT_BUTTON,true);
        String successMessage = action.getText(UIlocators.SUCCESS_MESSAGE, true);
        String uploadedFileName = action.getText(UIlocators.UPLOADED_FILE_NAME, true);
        Assert.assertEquals(successMessage,"File Uploaded!","failed to upload file");
        Assert.assertEquals(uploadedFileName,"task photo.jpg","failed to upload file");
    }

    public void dynamicLoading(String key){
        seleniumActions action = new seleniumActions(key);
        action.navigateTo(SystemProperties.getBaseWebsiteURL(),true);
        action.click(UIlocators.DYNAMIC_LOADING,true);
        action.click(UIlocators.EXAMPLE2,true);
        action.click(UIlocators.START_BUTTON,true);
        String successMessage = action.getText(UIlocators.TEXT_AFTER_LOADING, true);
        Assert.assertEquals(successMessage,"Hello World!","failed to load Hello World!");
    }
}
