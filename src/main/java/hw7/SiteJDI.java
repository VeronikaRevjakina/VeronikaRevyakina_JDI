package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.voids.HomePage;
import hw7.voids.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class SiteJDI {

    @Url("index.html")
    @Title("Home Page")
    public static HomePage homePage;

    @Url("metals-colors.html")
    @Title("Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homePage.open();
    }

}
