package pe.interbank.openbanking.userinterfaces.screens;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class LoginScreen {
    public static final Target BTN_CLOSE = Target.the("Boton cerrar").locatedForAndroid(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Close\"]")).
            locatedForIOS(AppiumBy.xpath("xxx"));

}
