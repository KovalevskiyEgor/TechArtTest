package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * страница с корзиной
 */
public class BasketPage {
    private final SelenideElement goToCheckout = $x("//a[contains(@class, 'button-style_primary')]");

    public void goToCheckout(){
        goToCheckout.click();

        screenshot("goToCheckout");
    }
}
