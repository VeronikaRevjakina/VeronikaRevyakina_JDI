package hw7;

import com.epam.jdi.light.driver.get.DriverData;
import hw7.entities.MetalsAndColors;
import hw7.entities.Users;
import hw7.enums.Pages;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class MetalsAndColorsTest {
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
    public void testMetalsAndColorsFormSubmitted() {
        SiteJDI.open();
        SiteJDI.homePage.login(Users.PITER);
        SiteJDI.homePage.isOpened();
        SiteJDI.homePage.checkLoggedin(Users.PITER);
        SiteJDI.homePage.openPageByHeaderMenu(Pages.METALS_AND_COLORS);
        SiteJDI.metalsAndColorsPage.isOpened();
        SiteJDI.metalsAndColorsPage.submitMetalsAndColorsForm(MetalsAndColors.DATA);
        SiteJDI.metalsAndColorsPage.checkLog(MetalsAndColors.DATA);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
