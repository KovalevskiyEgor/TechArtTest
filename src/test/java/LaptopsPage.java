import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class LaptopsPage {

    private final SelenideElement setLenovo =$x("//div[text()='Lenovo' and @class='catalog-form__checkbox-sign']");
    private final SelenideElement setSamsung =$x("//div[text()='Samsung' and @class='dropdown-style__checkbox-sign']");
    private final SelenideElement showAllLaptopModels = $x("//div[@class='input-style__real']");
    private final SelenideElement marketDateFrom = $x("//input[@type='text' and @class='input-style input-style_primary input-style_small catalog-form__input catalog-form__input_width_full' and @placeholder='2007']");
    private final SelenideElement marketDateTo = $x("//input[@type='text' and @class='input-style input-style_primary input-style_small catalog-form__input catalog-form__input_width_full' and @placeholder='2024']");
    private final SelenideElement setMatrix = $x("//div[@class='catalog-form__checkbox-sign' and text()='OLED']");
    private final SelenideElement setMaterial = $x("//div[@class='catalog-form__checkbox-sign' and text()='металл']");
    private final SelenideElement setNumpad = $x("//input[@type=\"checkbox\" and @name='numpad' and @value='0']/..");
    private final SelenideElement setSorting = $x("//option[@value='price:asc' and normalize-space(text())='Дешевые']");

    private final SelenideElement showAllFilters = $x("//div[@class='button-style button-style_complementary button-style_small catalog-form__button catalog-form__button_show-secondary']");

    private final SelenideElement scrollToMatrix = $x("//div[@class='catalog-form__label-title' and contains(text(), 'Матрица экрана')]");
    private final SelenideElement scrollToProducer = $x("//div[@class='catalog-form__label-title' and contains(text(), 'Производитель')]");
    private final SelenideElement scrollToBatteryCapacity = $x("//div[@class='catalog-form__label-title' and contains(text(), 'Емкость аккумулятора')]");
    private final SelenideElement scrollToMaterial = $x("//div[@class='catalog-form__label-title' and contains(text(), 'Материал корпуса')]");
    private final SelenideElement scrollToTop = $x("//h1[@class='catalog-form__title catalog-form__title_big-alter' and normalize-space(text())='Ноутбуки']");

    private final SelenideElement showSortingCriteries = $x("//div[@class='input-style__faux' and text()='Сначала популярные']/..");

    private final SelenideElement addToBasket = $x("(//a[contains(@class, 'button-style') and contains(@class, 'offers-list__button_cart') and contains(text(), 'В корзину')])[2]");
    private final SelenideElement goToBasket = $x("//a[contains(@class, 'button-style') and contains(text(), 'Перейти в корзину')]");
    private final SelenideElement goToCheckout = $x("//a[contains(@class, 'button-style_primary')]");
    private final SelenideElement goToPayment = $x("//button[contains(text(),'Перейти к способу оплаты')]");

    private final SelenideElement setCity = $x("//input[@placeholder='Укажите населенный пункт']");
    private final SelenideElement setComment = $x("//textarea[@placeholder='Укажите дополнительные детали']");
    private final SelenideElement setHouse = $x("//input[@type='text' and @maxlength='4']");
    private final SelenideElement setStreet = $x("(//input[@type='text' and contains(@class, 'auth-form__input')])[2]");
    private final SelenideElement setCorpus =$x("(//input[@maxlength='2' and contains(@class, 'input-style_primary')])[1]");
    private final SelenideElement setPodiest =$x("(//input[@maxlength='2' and contains(@class, 'input-style_primary')])[2]");
    private final SelenideElement setFloor =$x("(//input[@maxlength='3' and contains(@class, 'input-style_primary')])");
    private final SelenideElement setRoom =$x("(//input[@maxlength='6' and contains(@class, 'input-style_primary')])");
    private final SelenideElement setName =$x("//input[@wfd-id='id7']");
    private final SelenideElement setSurname =$x("//input[@wfd-id='id8']");
    private final SelenideElement setEmail =$x("//input[@wfd-id='id9']");


    private void readXmlWithPorducersAndSetFilter(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse("producers.xml");

            Element filtersElement = document.getDocumentElement();

            NodeList manufacturerNodes = filtersElement.getElementsByTagName("manufacturer");

            ArrayList<String> producersXpaths = new ArrayList<>();

            for (int i = 0; i < manufacturerNodes.getLength(); i++) {
                Element manufacturerElement = (Element) manufacturerNodes.item(i);
                String manufacturer = manufacturerElement.getTextContent();
                String xPath = "//div[text()='"+manufacturer+"' and @class='dropdown-style__checkbox-sign']";
                producersXpaths.add(xPath);
            }
            setProducers(producersXpaths);

        }catch (Exception e){
            setProducers(new ArrayList<>(Collections.singleton("//div[text()='Samsung' and @class='dropdown-style__checkbox-sign']")));
        }
    }

    private void setProducers(ArrayList<String> producersXpaths) {
        for(String xPath:producersXpaths){
            SelenideElement selenideElement = $x(xPath);
            selenideElement.click();
        }
    }


    public void setProducers(){
        scrollToProducer.scrollTo();
        showAllLaptopModels.click();

        readXmlWithPorducersAndSetFilter();
    }

    public void setMarketDateFromTo(){
        marketDateFrom.scrollTo().setValue("2015");
        marketDateTo.setValue("2023");
    }

    public void setMatrix(){
        scrollToMatrix.scrollTo();
        setMatrix.click();
    }

    public void setMaterial(){
        scrollToBatteryCapacity.scrollTo();
        showAllFilters.click();

        scrollToMaterial.scrollTo();
        setMaterial.click();
    }
    public void setNumpad(){
        SelenideElement selenideElement = $x("//div[contains(@class, 'catalog-form__offers_processing')]");
        setNumpad.click();
        selenideElement.should(appear);
        selenideElement.should(disappear);
        scrollToTop.scrollTo();
    }

    public void getAverageLaptop(){
        ElementsCollection spanElements = $$(By.xpath("//a[@class='catalog-form__link catalog-form__link_nodecor catalog-form__link_primary-additional catalog-form__link_huge-additional catalog-form__link_font-weight_bold']/span[2]"));
        String xPath = getAverageLaptop(spanElements);
        SelenideElement laptopPrice = $x(xPath);
        laptopPrice.scrollTo();
        SelenideElement laptopButton = $x(xPath+"/../../../div[contains(@class, 'catalog-form__control')]/a");
        System.out.println(xPath+"/../../../div[contains(@class, 'catalog-form__control')]/a");
        laptopButton.click();

    }


    private String getAverageLaptop(ElementsCollection webElements){
        List<String> elementTexts = webElements.texts();

        // Сортируем список строк (элементов) по возрастанию
        List<String> sortedTexts = elementTexts.stream()
                .sorted()
                .collect(Collectors.toList());
        String price = sortedTexts.get(sortedTexts.size()/2);

        WebElement webElement = webElements.get(webElements.size()/2);
        System.out.println("//span[contains(text(), '"+ price+"') and contains(text(), 'р.')]/../../../..");

        return ("//span[contains(text(), '"+ price.replace("р","").replace(".","").trim()+"') and contains(text(), 'р.')]");
    }
}
