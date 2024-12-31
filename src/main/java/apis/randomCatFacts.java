package apis;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.Assert;
import utilis.APIBase;

public class randomCatFacts extends APIBase {

    private ExtentTest test;

    // Constructor to pass ExtentTest object
    public randomCatFacts(ExtentTest test) {
        this.test = test;
    }

    // Method to call the API
    public String callGetFactsAPI() {
        String endPoint = "facts";
        Response response = APIBase.GET(endPoint); // Call the API
        int responseCode = response.getStatusCode();
        if (PRINT_ALL) System.out.println(response.asPrettyString());
        Assert.assertEquals(responseCode, 200, "Failed for " + endPoint + "\n" + response.asPrettyString());
        return response.asString();
    }
}
