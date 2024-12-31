package utilis;


import org.json.JSONException;
import org.json.JSONArray;

import static utilis.SystemProperties.softAssert;

public class parser {
    public Object parseJsonAndGetObject(String printOnError,String json, int index, String obj){
        Object o = null;
        try{
            JSONArray jsonArray = new JSONArray(json);
            o=jsonArray.getJSONObject(index).get(obj);
        }catch (JSONException e1){
            errorBehaviour(printOnError, obj);
        }
        return o;
    }
    public void errorBehaviour(String printOnError, String json) {
        System.out.println("failed to find " + json);
        System.out.println(printOnError);
        softAssert.fail("failed to find " + json + " in method " + printOnError);

    }
}
