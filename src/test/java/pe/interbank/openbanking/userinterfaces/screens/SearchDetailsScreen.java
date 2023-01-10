package pe.interbank.openbanking.userinterfaces.screens;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchDetailsScreen {
    public static final Target SEARCH_DETAIL_INPUT = Target.the("Search Detail Input").locatedForAndroid(AppiumBy.id("search_input")).
            locatedForIOS(AppiumBy.id("search_input"));
    public static final Target SEARCH_DETAIL_INPUT_TEXT = Target.the("Search Detailt Input Text").locatedForAndroid(AppiumBy.id("2131429999")).
            locatedForIOS(AppiumBy.id("2131429999"));
    public static final Target FIRST_OPTION = Target.the("First Option").locatedForAndroid(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")).
            locatedForIOS(AppiumBy.xpath("xxx"));
    public static final Target NEXT_BUTTON = Target.the("Next button").locatedForAndroid(AppiumBy.id("2131430997")).
            locatedForIOS(AppiumBy.id("2131430997"));
    public static final Target SEARCH_BUTTON = Target.the("Search button").locatedForAndroid(AppiumBy.id("2131430822")).
            locatedForIOS(AppiumBy.id("2131430822"));
}
