import org.testng.annotations.Test;

public class OnlinerTest extends BaseTest{
    private final static String BASE_URL = "https://www.onliner.by/";

    @Test
    public void testHref(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickOnSearch();

        LaptopsPage laptopsPage = new LaptopsPage();
        laptopsPage.setProducers();
        laptopsPage.setMarketDateFromTo();
        laptopsPage.setMatrix();
        laptopsPage.setMaterial();
        laptopsPage.setNumpad();
        laptopsPage.getAverageLaptop();

        LaptopCharacteristicPage laptopCharacteristicPage = new LaptopCharacteristicPage();
        laptopCharacteristicPage.addToBasket();
        laptopCharacteristicPage.goToCheckout();

        BasketPage basketPage = new BasketPage();
        basketPage.goToCheckout();

        OrderPage orderPage = new OrderPage();
        orderPage.setCity("Минск");
        orderPage.setStreet("ул. Орловская");
        orderPage.setCorpus("1");
        orderPage.setName("Егор");
        orderPage.setSurname("Ковалевский");
        orderPage.setFloor("1");
        orderPage.setHouse("10");
        orderPage.setComment("aaaaa");
        orderPage.setRoom("200");
        orderPage.setPodiest("4");
    }

}
