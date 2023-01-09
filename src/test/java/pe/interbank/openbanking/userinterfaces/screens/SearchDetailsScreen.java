package pe.interbank.openbanking.userinterfaces.screens;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchDetailsScreen {
    public static final Target SEARCH_DETAIL_INPUT = Target.the("Search Detail Input").located(By.id("search_input"));
    public static final Target SEARCH_DETAIL_INPUT_TEXT = Target.the("Search Detailt Input Text").located(By.id("2131429999"));
    public static final Target FIRST_OPTION = Target.the("First Option").locatedBy("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView");
    public static final Target NEXT_BUTTON = Target.the("Next button").located(By.id("2131430997"));
    public static final Target SEARCH_BUTTON = Target.the("Search button").located(By.id("2131430822"));
}
