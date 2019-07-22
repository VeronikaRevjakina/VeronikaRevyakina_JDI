package hw7;

import com.epam.jdi.light.driver.get.DriverData;
import hw7.entities.MetalsAndColorsData;
import hw7.entities.Users;
import hw7.enums.Menu;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class BaseTest {
    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(SiteJDI.class);
    }

    @Test
    public void exerciseTest() {
        SiteJDI.open();
        SiteJDI.homePage.login(Users.PITER);
        SiteJDI.homePage.isOpened();
        SiteJDI.homePage.checkLoggedin(Users.PITER);
        SiteJDI.homePage.clickHeaderMenuButton(Menu.METALS_AND_COLORS);
        SiteJDI.metalsAndColorsPage.isOpened();
        // TODO Pay attention on code convention, you should not start ne line from method arguments.
        SiteJDI.metalsAndColorsPage.fillMetalsAndColorsForm
                (MetalsAndColorsData.DATA);
        SiteJDI.metalsAndColorsPage.submitMetalsAndColorsForm();
        SiteJDI.metalsAndColorsPage.checkResultsBlockOutput
                (MetalsAndColorsData.DATA);

    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
