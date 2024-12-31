package helpers.api;

import apis.randomCatFacts;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import utilis.parser;

public class catFacts {

    private ExtentTest test;

    // Constructor to pass ExtentTest instance for logging
    public catFacts(ExtentTest test) {
        this.test = test;
    }

    // Method to get random cat facts
    public void getRandomCatFacts() {
        randomCatFacts facts = new randomCatFacts(test);
        String json = facts.callGetFactsAPI();
        parser parse = new parser();
        String randomFact = parse.parseJsonAndGetObject("failed to get text fact", json, 0, "text").toString();
        try {
            Assert.assertNotEquals(randomFact, null, "Text is null");
            Assert.assertFalse(randomFact.isEmpty(), "Text is empty");
            test.pass("Random Cat Fact: " + json);

        } catch (AssertionError e) {
            test.fail("Test failed: " + e.getMessage());
            test.fail("API Response: " + json);
        }
    }
}
