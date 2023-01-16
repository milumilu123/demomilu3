package pe.interbank.openbanking.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {
    public static final Target PRODUCT_NAME = Target.the("Producto").located(By.id("item_4_title_link"));
    public static final Target PRODUCTS_TITLE = Target.the("Título Productos").locatedBy("//span[contains(text(),'Products')]");
    public static final Target BTN_MENU = Target.the("Menú").located(By.id("react-burger-menu-btn"));
    public static final Target BTN_LOGOUT = Target.the("Logout").located(By.id("logout_sidebar_link"));
}
