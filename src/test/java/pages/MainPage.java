package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта onliner.by
 */

public class MainPage {
    private final SelenideElement laptopButton =$x("//span[@class='project-navigation__sign' and text()='Ноутбуки']");

    public MainPage(String url){
        Selenide.open(url);
    }

    public void clickOnSearch(){
        laptopButton.click();
    }

}
