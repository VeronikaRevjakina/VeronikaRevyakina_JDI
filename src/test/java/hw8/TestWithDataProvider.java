package hw8;

import com.epam.jdi.light.driver.get.DriverData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import hw8.entities.MetalsAndColors;
import hw8.entities.Users;
import hw8.enums.Pages;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class TestWithDataProvider {

    private static final String METALS_COLORS_DATA_SET = "src/test/resources/" +
            "hw8/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "data")
    public Object[] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser()
                .parse(new FileReader(METALS_COLORS_DATA_SET));

        Map<String, MetalsAndColors> testData = new Gson()
                .fromJson(jsonData, new TypeToken<Map<String, MetalsAndColors>>() {}
                        .getType());

        return testData.values().toArray();
    }

    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(SiteJDI.class);

        SiteJDI.open();
        SiteJDI.homePage.login(Users.PITER);
        SiteJDI.homePage.isOpened();
        SiteJDI.homePage.checkLoggedin(Users.PITER);
    }

    @Test(dataProvider = "data")
    public void exerciseTest(MetalsAndColors data) {
        SiteJDI.homePage.openPageByHeaderMenu(Pages.METALS_AND_COLORS);
        SiteJDI.metalsAndColorsPage.isOpened();
        SiteJDI.metalsAndColorsPage.submitMetalsAndColorsForm(data);
        SiteJDI.metalsAndColorsPage.checkLog(data);

    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
