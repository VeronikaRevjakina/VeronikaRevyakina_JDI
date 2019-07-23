package hw8.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Image;
import com.epam.jdi.light.ui.html.common.TextField;
import hw8.entities.Users;

public class LoginForm extends Form<Users> {

    @FindBy(css = "#user-icon")
    private Image userIcon;

    @FindBy(css = "#name")
    private TextField login;

    @FindBy(css = "#password")
    private TextField password;

    @FindBy(css = "#login-button")
    private Button submit;

    @Override
    public void login(Users user) {
        userIcon.click();

        login.input(user.getLogin());
        password.input(user.getPassword());

        submit.click();
    }
}
