package pe.interbank.openbanking.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {
    public static final Target PRODUCTS_TITLE = Target.the("Título productos").locatedBy("//span[contains(text(),'Products')]");
}
