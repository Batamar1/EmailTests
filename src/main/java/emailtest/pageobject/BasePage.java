package emailtest.pageobject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public abstract class BasePage {
    private final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebElement waitUntilElementVisible(WebElement element){
        return waitUntilElementVisible(element, 1);
    }

    protected WebElement waitUntilElementVisible(WebElement element, int second){
        new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(second))
                .ignoring(StaleElementReferenceException.class)
                //.until(el -> element.);
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
