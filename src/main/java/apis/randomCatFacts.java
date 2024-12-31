package helpers.api;

import io.restassured.response.Response;
import utilis.APIBase;

public class randomCatFacts extends APIBase{

    public void getFacts(){
        Response response = APIBase.GET("facts");
        int responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode, 200, "failed for " + endPoint + "\n" + response.asPrettyString());
    }
}
