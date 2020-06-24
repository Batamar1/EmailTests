package emailtest.pageobject;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailBoxPage extends BasePage{
    @Getter
    public final String URL = "";

    @FindBy(xpath = "//a[@href='https://passport.yandex.ru']")
    private WebElement userAccountMenu;

    @FindBy(xpath = "//span[@class='user-account__name']")
    private WebElement userAccountName;

    @FindBy(xpath = "//span[text()='Написать']/parent::a")
    private WebElement writeButton;

    @FindBy(className = "composeYabbles")
    private WebElement inputReceiver;

    //TODO
//    @FindBy(className = "ComposeYabble-Text")
//    private WebElement inputReceiverString;
//
//    @FindBy(className = "mail-MessageSnippet-Item mail-MessageSnippet-Item_subject")
//    private WebElement inputSubjectString;

    @FindBy(name = "subject")
    private WebElement inputSubject;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement inputMessage;

    @FindBy(xpath = "//span[text()='Отправить']/ancestor::button")
    private WebElement sendButton;

    @FindBy(className = "composeHeader-SavedAt")
    private WebElement emailSavedAt;

    @FindBy(xpath = "//a[@data-title='Отправленные']")
    private WebElement buttonSent;

    @FindBy(xpath = "//a[@data-title='Черновики']")
    private WebElement buttonDraft;

    @FindBy(className = "mail-MessageSnippet-Content")
    private WebElement mailString;

    @FindBy(xpath = "//a[@aria-label='Выйти из аккаунта']")
    private WebElement logout;

    @FindBy(xpath = "//span[@class = 'mail-Message-Toolbar-Subject-Wrapper']/child::div")
    private WebElement mailSubjectString;

    @FindBy(xpath = "//div[@class = 'js-message-body-content mail-Message-Body-Content']/child::div")
    private WebElement mailMessageString;

    @Autowired
    public EmailBoxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openUserAccountMenu(){
        super.waitUntilElementVisible(userAccountMenu).click();
    }

    public String getStringUserAccountName(){
        return super.waitUntilElementVisible(userAccountName).getText();
    }

    public void writeButton(){
        super.waitUntilElementVisible(writeButton).click();
    };

    public void fillReceiver(String receiver){
     //   System.out.println("String = " + receiver);
        super.waitUntilElementVisible(inputReceiver).sendKeys(receiver);
        //System.out.println("String 2 = " + receiverInput.getText());
        inputReceiver.sendKeys(Keys.ENTER);
       // System.out.println("String 3 = " + receiverInput.getText());
    }

    public void fillSubject(String subject){
        super.waitUntilElementVisible(inputSubject).sendKeys(subject);
    }

    public void fillMessage(String message){
        super.waitUntilElementVisible(inputMessage).sendKeys(message);
    }

    public void sendEmail(){
        super.waitUntilElementVisible(sendButton).click();
    }

    public void openDrafts(){
        super.waitUntilElementVisible(buttonDraft).click();
        buttonDraft.click();
    }

    public void openSent(){
        super.waitUntilElementVisible(buttonSent).click();
        buttonSent.click();
    }

    public void openLastEmail() {
        super.waitUntilElementVisible(mailString,3).click();
    }

    //TODO
//
//    public String getStringFormReceiver(){
//        return super.waitUntilElementVisible(inputReceiverString).getText();
//    }
//
    public String getStringFormSubject(){
        return super.waitUntilElementVisible(inputSubject).getAttribute("value");
    }

    public String getStringFormMessage(){
        return super.waitUntilElementVisible(inputMessage).getText();
    }

    public String getStringSubject(){
        return super.waitUntilElementVisible(mailSubjectString).getText();
    }

    public String getStringMessage(){
        return super.waitUntilElementVisible(mailMessageString).getText();
    }

    public boolean isFormNewEmailDisplayed(){
        return sendButton.isDisplayed();
    }

    public void clickLogout(){
        logout.click();
    }

}
