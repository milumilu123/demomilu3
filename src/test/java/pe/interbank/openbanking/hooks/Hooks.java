package pe.interbank.openbanking.hooks;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void actorCanBrowseTheMobileApp(){
        OnStage.setTheStage(new OnlineCast());
    }

}
