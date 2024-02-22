package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * страница оформления заказа
 */
public class OrderPage {
    private final SelenideElement setCity = $x("//input[@placeholder='Укажите населенный пункт']");
    private final SelenideElement setComment = $x("//textarea[@placeholder='Укажите дополнительные детали']");
    private final SelenideElement setStreet = $x("//input[@wfd-id='id1']");
    private final SelenideElement setHouse = $x("//input[@wfd-id='id2']");
    private final SelenideElement setCorpus =$x("//input[@wfd-id='id3']");
    private final SelenideElement setPodiest =$x("//input[@wfd-id='id4']");
    private final SelenideElement setFloor =$x("//input[@wfd-id='id5']");
    private final SelenideElement setRoom =$x("//input[@wfd-id='id6']");
    private final SelenideElement setName =$x("//input[@wfd-id='id7']");
    private final SelenideElement setSurname =$x("//input[@wfd-id='id8']");
    private final SelenideElement setEmail =$x("//input[@wfd-id='id9']");

    public void setEmail(String s){
        setEmail.setValue(s);
        screenshot("setEmail");
    }
    public void setCity(String s){
        setCity.setValue(s);
        screenshot("setCity");
    }
    public void setStreet(String s){
        setStreet.setValue(s);
        screenshot("setStreet");
    }
    public void setHouse(String s){
        setHouse.setValue(s);
        screenshot("setHouse");
    }
    public void setCorpus(String s){
        setCorpus.setValue(s);
        screenshot("setCorpus");
    }
    public void setPodiest(String s){
        setPodiest.setValue(s);
        screenshot("setPodiest");
    }
    public void setFloor(String s){
        setFloor.setValue(s);
        screenshot("setFloor");
    }
    public void setRoom(String s){
        setRoom.setValue(s);
        screenshot("setRoom");
    }
    public void setComment(String s){
        setComment.setValue(s);
        screenshot("setComment");
    }
    public void setName(String s){
        setName.setValue(s);
        screenshot("setName");
    }
    public void setSurname(String s){
        setSurname.setValue(s);
        screenshot("setSurname");
    }

}
