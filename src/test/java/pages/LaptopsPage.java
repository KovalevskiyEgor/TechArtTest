package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Страница с ноутбуками
 */
@Slf4j
public class LaptopsPage {
    private final SelenideElement showAllLaptopModelsButton = $x("//div[@class='input-style__real']");
    private final SelenideElement showAllFiltersButton = $x("//div[@class='button-style button-style_complementary button-style_small catalog-form__button catalog-form__button_show-secondary']");

    private final SelenideElement marketDateFrom = $x("//input[@type='text' and @class='input-style input-style_primary input-style_small catalog-form__input catalog-form__input_width_full' and @placeholder='2007']");
    private final SelenideElement marketDateTo = $x("//input[@type='text' and @class='input-style input-style_primary input-style_small catalog-form__input catalog-form__input_width_full' and @placeholder='2024']");

    private final SelenideElement scrollToMatrix = $x("//div[@class='catalog-form__label-title' and contains(text(), 'Матрица экрана')]");
    private final SelenideElement scrollToProducer = $x("//div[@class='catalog-form__label-title' and contains(text(), 'Производитель')]");
    private final SelenideElement scrollToBatteryCapacity = $x("//div[@class='catalog-form__label-title' and contains(text(), 'Емкость аккумулятора')]");
    private final SelenideElement scrollToMaterial = $x("//div[@class='catalog-form__label-title' and contains(text(), 'Материал корпуса')]");
    private final SelenideElement scrollToTop = $x("//h1[@class='catalog-form__title catalog-form__title_big-alter' and normalize-space(text())='Ноутбуки']");

    public void setProducers(){
        scrollToProducer.scrollTo();
        showAllLaptopModelsButton.click();

        readXmlWithPorducersAndSetFilter();

        screenshot("setProducers");
    }

    public void setMarketDateFromTo(String from, String to){
        marketDateFrom.scrollTo().setValue(from);
        marketDateTo.setValue(to);

        screenshot("setMarketDateFromTo");
    }

    public void setMatrix(String matrix){
        SelenideElement setMatrix = $x(String.format("//div[@class='catalog-form__checkbox-sign' and text()='%s']",matrix));
        scrollToMatrix.scrollTo();
        setMatrix.click();

        screenshot("setMatrix");
    }

    public void setMaterial(String material){
        SelenideElement setMaterial = $x(String.format("//div[@class='catalog-form__checkbox-sign' and text()='%s']",material));

        scrollToBatteryCapacity.scrollTo();
        showAllFiltersButton.click();

        scrollToMaterial.scrollTo();
        setMaterial.click();

        screenshot("setMaterial");
    }
    public void setNumpad(String s){
        String haveNumpadOrNo = s.equals("Да")?"1":"0";
        SelenideElement setNumpad = $x(String.format("//input[@type=\"checkbox\" and @name='numpad' and @value='%s']/..",haveNumpadOrNo));
        SelenideElement selenideElement = $x("//div[contains(@class, 'catalog-form__offers_processing')]");
        setNumpad.click();
        selenideElement.should(disappear);
        scrollToTop.scrollTo();

        screenshot("setNumpad");
    }

    public void getAverageLaptop(){
        ElementsCollection spanElements = $$(By.xpath("//a[@class='catalog-form__link catalog-form__link_nodecor catalog-form__link_primary-additional catalog-form__link_huge-additional catalog-form__link_font-weight_bold']/span[2]"));
        if(spanElements.isEmpty()) {
            log.info("НОУТБУКОВ С ТАКИМ ФИЛЬТРОМ НЕ НАЙДЕНО");
            return;
        }

        String xPath = getAverageLaptop(spanElements);
        SelenideElement laptopPrice = $x(xPath);
        laptopPrice.scrollTo();
        SelenideElement laptopButton = $x(xPath+"/../../../div[contains(@class, 'catalog-form__control')]/a");
        laptopButton.click();

        screenshot("getAverageLaptop");
    }

    private String getAverageLaptop(ElementsCollection webElements){
        List<String> elementTexts = webElements.texts();

        List<String> sortedTexts = elementTexts.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> sortedByLength = sortedTexts.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

                String price = sortedByLength.get(sortedTexts.size()/2);

        return ("//span[contains(text(), '"+ price.replace("р","").replace(".","").trim()+"') and contains(text(), 'р.')]");
    }
    private void readXmlWithPorducersAndSetFilter() {
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
                String xPath = "//div[text()='" + manufacturer + "' and @class='dropdown-style__checkbox-sign']";
                producersXpaths.add(xPath);
            }
            setProducers(producersXpaths);

    } catch (Exception e) {
        setProducers(new ArrayList<>(Collections.singleton("//div[text()='Samsung' and @class='dropdown-style__checkbox-sign']")));
    }

}
    private void setProducers (ArrayList < String > producersXpaths) {
        for (String xPath : producersXpaths) {
            SelenideElement selenideElement = $x(xPath);
            selenideElement.click();
        }
    }
}