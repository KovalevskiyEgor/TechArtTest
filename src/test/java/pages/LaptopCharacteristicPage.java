package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * страница с характеристиками ноутбука, на которой бы добавим его в корзину
 */
public class LaptopCharacteristicPage {
    private final SelenideElement goToBasket = $x("//a[contains(@class, 'button-style') and contains(text(), 'Перейти в корзину')]");
    private final SelenideElement minPrice =$x("//div[contains(@class,'offers-description__price')]");
    private final SelenideElement laptopModel = $x("//h1");

    public void addToBasket(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/LaptopModelAndItsPrice.txt"))) {
            String modelPrice = laptopModel.getText().replaceAll("Цены на ","")+"-"+minPrice.getText();
            writer.write(modelPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SelenideElement minPriceLaptopButton = $x("(//div[contains(text(),'"+minPrice.getText().substring(0,minPrice.getText().length()-3)+"')])[3]/../../../div[contains(@class,'offers-list__part_action')]/div[1]/a[2]");
        minPriceLaptopButton.click();

        screenshot("addToBasket");
    }

    public void goToCheckout(){
        goToBasket.click();

        screenshot("goToCheckout");
    }
}
