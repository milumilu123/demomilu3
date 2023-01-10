package pe.interbank.openbanking.hooks;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

public class Hooks {
    @Before
    public void actorCanBrowseTheMobileApp(){
        OnStage.setTheStage(new OnlineCast());
    }
}
