package hw7.voids;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Label;
import hw7.entities.Users;
import hw7.enums.Menu;
import hw7.forms.LoginForm;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

public class HomePage extends WebPage {

    private LoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @XPath("//*[@class='uui-navigation nav navbar-nav m-l8']")
    private UIElement menu;

    public void login(Users user) {
        loginForm.login(user);
    }

    public void checkLoggedin(Users user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
    }

    public void clickHeaderMenuButton(Menu menuItem) {
        // TODO This is completely prohibited to use raw selenium calls in PO method directly !--Fixed
        menu.find(By.xpath("//a[contains(.,'" + menuItem.getName() + "')]"))
                .click();
    }
}
