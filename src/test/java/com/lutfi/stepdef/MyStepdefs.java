import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("user is on login page")
    public void userIsOnLoginPage() {
    }

    @When("user input email with {string}")
    public void userInputEmailWith(String username) {
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
    }

    @And("user click login button")
    public void userClickLoginButton() {
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
    }

    @When("user input email text {string}")
    public void userInputEmailText(String arg0) {
    }

    @And("user input password text {string}")
    public void userInputPasswordText(String arg0) {
    }
}
