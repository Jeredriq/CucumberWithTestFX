
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import javafx.scene.control.Label;


import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class MyStepdefs extends TestFXBase  {
//implements En
//    public MyStepdefs() {
//        Given("^That \"([^\"]*)\" Exists$", ((String arg0) -> assertNodeExists(hasText(arg0))));
//        Then("^Which is \"([^\"]*)\"$",((StepdefBody.A1<String>) System.out::println));
//    }

    @Given("^That \"([^\"]*)\" Exists$")
    public void thatExists(String arg0) {
        String labelText = "Can you find this label text";
        clickOn(labelText);
        sleep(1000);
        verifyThat("#labelId",(Label label)-> {
            String text = label.getText();
            return text.contains(labelText);
        });
    }

    @Then("^Which is \"([^\"]*)\"$")
    public void whichIs(String arg0) {
        System.out.println(arg0);
    }
}
