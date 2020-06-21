package emailtest.pageobject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public abstract class BasePage {
    @Autowired
    protected WebDriver driver;
}
