package sergei.com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={
                "html:target/cucumber-report.html", // cucumber-html report
                "rerun:target/rerun.txt",  // to catch and store failed scenarios
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"// cucumber report, which looks better

        },
        features = "src/test/resources/features",
        glue = "sergei/com/steps",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {

}




