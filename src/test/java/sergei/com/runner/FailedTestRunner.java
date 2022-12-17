package sergei.com.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt", //@ sigh need because target folder and refreshed with every running,
        glue = "sergei/com/steps"


)
public class FailedTestRunner {
}
