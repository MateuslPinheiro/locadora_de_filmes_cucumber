package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/locadora.feature",
        glue = "steps",
        plugin = "pretty", //Deixa bonitinho
        monochrome = true, //Tira as cores
        snippets = SnippetType.CAMELCASE, //Coloca os STEPS em Camel Case
        dryRun = false,
        strict = false // Aumenta o rigor da plotagem
)
public class Runner {
}
