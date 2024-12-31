package utilis;

import org.testng.asserts.SoftAssert;

public class SystemProperties {

    public static final String LOCAL_TEST_ENV = "Google";
    public static final boolean PRINT_ALL = true;
    public static SoftAssert softAssert = new SoftAssert();


    private static String baseAPIsURL;
    private static String baseWebsiteURL;
    public static String env;

    private static void initialize(String env){
        if (env == null) env = LOCAL_TEST_ENV;
        if (env.equalsIgnoreCase("Google"))
            setBaseWebsiteURL("https://www.google.com/ncr");
        else if (env.equalsIgnoreCase("heroku app"))
            setBaseWebsiteURL("https://the-internet.herokuapp.com");
        else if (env.equalsIgnoreCase("cat facts")) {
            setBaseAPIsURL("https://cat-fact.herokuapp.com/");
        }
        System.out.println("Initializing with environment: " + env);

    }

    public static String getEnv() {
        return env;
    }
    public static String getBaseAPIsURL() {
        return baseAPIsURL;
    }
    public static String getBaseWebsiteURL() {
        return baseWebsiteURL;
    }
    public static void setBaseAPIsURL(String baseAPIsURL) {
        SystemProperties.baseAPIsURL = baseAPIsURL;
    }
    public static void setEnv(String env) {
        SystemProperties.env = env;
        initialize(env);
    }
    public static void setBaseWebsiteURL(String baseWebsiteURL) {
        SystemProperties.baseWebsiteURL = baseWebsiteURL;
    }


}
