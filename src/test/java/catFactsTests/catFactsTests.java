package catFactsTests;
import helpers.api.catFacts;
import org.testng.annotations.Test;

public class catFactsTests {
    @Test
    public void assertFactsIsNotEmpty(){
        catFacts facts = new catFacts();
        facts.getRandomCatFacts();
    }
}
