package pe.interbank.openbanking.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {
    public static final Target PRODUCTS_TITLE = Target.the("Título productos").locatedBy("//span[contains(text(),'Products')]");
    public static final Target BTN_MENU = Target.the("Menú").located(By.id("react-burger-menu-btn"));
    public static final Target BTN_LOGOUT = Target.the("Logout").located(By.id("logout_sidebar_link"));
}
