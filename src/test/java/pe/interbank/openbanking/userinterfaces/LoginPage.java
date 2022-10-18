package pe.interbank.openbanking.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME_INPUT = Target.the("Campo usuario").located(By.id("user-name"));
    public static final Target PASSWORD_INPUT = Target.the("Campo password").locatedBy("#password");
    public static final Target LOGIN_BUTTON = Target.the("Botón login").located(By.id("login-button"));
    public static final Target ERROR_TEXT = Target.the("Mensaje de error").locatedBy("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]");
}
