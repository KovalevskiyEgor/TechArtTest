package tests;

import org.testng.annotations.Test;
import pages.*;

public class OnlinerTest extends BaseTest{
    private final static String BASE_URL = "https://www.onliner.by/";

    @Test
    public void testHref(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickOnSearch();

        LaptopsPage laptopsPage = new LaptopsPage();
        laptopsPage.setProducers();
        laptopsPage.setMarketDateFromTo("2015","2023");
        laptopsPage.setMatrix("OLED");
        laptopsPage.setMaterial("металл");
        laptopsPage.setNumpad("Нет");
        laptopsPage.getAverageLaptop();

        LaptopCharacteristicPage laptopCharacteristicPage = new LaptopCharacteristicPage();
        laptopCharacteristicPage.addToBasket();
        laptopCharacteristicPage.goToCheckout();

        BasketPage basketPage = new BasketPage();
        basketPage.goToCheckout();

        OrderPage orderPage = new OrderPage();
        orderPage.setCity("Минск");
        orderPage.setStreet("ул. Орловская");
        orderPage.setHouse("10");
        orderPage.setCorpus("1");
        orderPage.setPodiest("4");
        orderPage.setFloor("1");
        orderPage.setRoom("200");
        orderPage.setComment("Возьмите на стажировку хотяб (пожалуйста) (по возможности)");
        orderPage.setName("Егор");
        orderPage.setSurname("Ковалевский");
        orderPage.setEmail("kovalevskiy_egor@mail.ru");
    }

}
