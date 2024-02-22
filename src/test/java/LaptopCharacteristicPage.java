import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LaptopCharacteristicPage {
    private final SelenideElement sortByPrice = $x("//option[@value='price:desc']");
    private final SelenideElement addToBasket = $x("(//a[contains(@class, 'button-style') and contains(@class, 'offers-list__button_cart') and contains(text(), 'В корзину')])[2]");
    private final SelenideElement goToBasket = $x("//a[contains(@class, 'button-style') and contains(text(), 'Перейти в корзину')]");
    private final SelenideElement minPrice =$x("//div[contains(@class,'offers-description__price')]");


    public void addToBasket(){
        SelenideElement minPriceLaptopButton = $x("(//div[contains(text(),'"+minPrice.getText().substring(0,minPrice.getText().length()-3)+"')])[3]/../../../div[contains(@class,'offers-list__part_action')]/div[1]/a[2]");
        minPriceLaptopButton.click();
    }

    public void goToCheckout(){
        goToBasket.click();
    }
}
