package sergei.com.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sergei.com.pages.LoginPage;
import sergei.utility.BrowserUtil;
import sergei.utility.Driver;

public class US_0_Login_Step {
LoginPage loginPage = new LoginPage();

    @When("librarian login with credentials {string} and  {string}")
    public void librarian_login_with_credantials_and(String email, String password) {
        BrowserUtil.waitFor(1);
        loginPage.login(email, password);

    }

    @Then("verify the user should be at dashboard page with title {string}")
    public void verifyTheUserShouldBeAtDashboardPageWithTitle(String title) {
BrowserUtil.waitFor(1);
        String actualTitcle = Driver.getDriver().getTitle();
        Assert.assertEquals(title, actualTitcle);

    }

    @When("student login with credentials {string} and  {string}")
    public void studentLoginWithCredentialsAnd(String email, String password) {
        loginPage.login(email, password);

    }
}
