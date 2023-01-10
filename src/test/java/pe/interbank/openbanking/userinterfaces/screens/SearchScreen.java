package pe.interbank.openbanking.userinterfaces.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchScreen {
    public static final Target SEARCH_INPUT = Target.the("Search Input").locatedForAndroid(AppiumBy.id("2131432049")).
            locatedForIOS(AppiumBy.id("2131432049"));
    public static final Target RESULT_TEXT = Target.the("Result Text").locatedForAndroid(AppiumBy.id("2131431007")).
            locatedForIOS(AppiumBy.id("2131431007"));
}
