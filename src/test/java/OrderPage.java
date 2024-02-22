import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {
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

    public void setCity(String s){
        setCity.setValue(s);
    }
    public void setStreet(String s){
        setStreet.setValue(s);
    }
    public void setHouse(String s){
        setHouse.setValue(s);
    }
    public void setCorpus(String s){
        setCorpus.setValue(s);
    }
    public void setPodiest(String s){
        setPodiest.setValue(s);
    }
    public void setFloor(String s){
        setFloor.setValue(s);
    }
    public void setRoom(String s){
        setPodiest.setValue(s);
    }
    public void setComment(String s){
        setComment.setValue(s);
    }
    public void setName(String s){
        setName.setValue(s);
    }
    public void setSurname(String s){
        setSurname.setValue(s);
    }


}
