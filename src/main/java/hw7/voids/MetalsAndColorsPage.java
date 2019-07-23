package hw7.voids;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.entities.MetalsAndColors;
import hw7.forms.MetalsAndColorsForm;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MetalsAndColorsPage extends WebPage {

    @Css("ul[class='panel-body-list results'] ")
    private UIElement resultBlock;

    private MetalsAndColorsForm metalsAndColorsForm;

    public void submitMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.submit(metalsAndColors);
    }

    public void checkLog(MetalsAndColors metalsAndColors) {
        assertThat(
                getActualResultBlockValues(),
                containsInAnyOrder(metalsAndColors.asArray())
        );
    }

    private List<String> getActualResultBlockValues() {
        return asList(resultBlock.text().split("\n"));
    }
}
