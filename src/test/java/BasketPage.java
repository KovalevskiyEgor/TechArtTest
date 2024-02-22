import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {
    private final SelenideElement goToCheckout = $x("//a[contains(@class, 'button-style_primary')]");

    public void goToCheckout(){
        goToCheckout.click();
    }
}
