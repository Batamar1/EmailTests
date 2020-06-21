package emailtest.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class EmailBoxPage extends BasePage {

    @FindBy(xpath = "//span[text()='Написать']/parent::a")
    private WebElement writeButton;

    @FindBy(className = "composeYabbles")
    private WebElement ReceiverInput;

    @FindBy(name = "subject")
    private WebElement subjectInput;

    @FindBy(id = "editor31")
    private WebElement inputText;

    public void writeButton(){
        this.writeButton.click();
    };

    public void inputReceiver(String receiver){
        ReceiverInput.sendKeys(receiver);
        ReceiverInput.sendKeys(Keys.ENTER);
    }

    public void inputSubject(String subject){
        subjectInput.sendKeys(subject);
    }

    public void inputText(String text){
        inputText.sendKeys(text);
    }

}
