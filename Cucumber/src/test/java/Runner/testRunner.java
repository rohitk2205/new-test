package Runner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/feature",
		glue="stepdefination",
		tags="@Excer1"
		)

public class testRunner {

}
