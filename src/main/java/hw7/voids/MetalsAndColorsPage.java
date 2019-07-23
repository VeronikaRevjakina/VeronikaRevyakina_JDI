package hw7.voids;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.entities.MetalsAndColorsData;
import hw7.enums.*;
import hw7.forms.MetalsAndColorsForm;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MetalsAndColorsPage extends WebPage {

    // TODO This element should belongs to the form.--Fixed

    @Css("ul[class='panel-body-list results'] ")
    private UIElement resultBlock;

    private MetalsAndColorsForm metalsAndColorsForm;

    public UIElement findResultBlockByOption(ResultOptions option) {
        return resultBlock.find
                (By.xpath(".//li[contains(string(),'" + option.getOption() + "')]"));
    }

    // TODO It will be better to encapsulate this calls to M______m. (fill the gap)--Fixed
    public void fillMetalsAndColorsForm(MetalsAndColorsData data) {
        metalsAndColorsForm.fillMetalsAndColorsForm(data);
    }


    // !TODO

    // TODO The certain sequence of log's rows doesn't matter in this case.--Fixed
    // It will be easier to compare just two List<strings>
    // First list you can generate from MetalsAndColors instance
    // Second list can be generated from Log ui-element
    public void checkResultsBlockOutput(MetalsAndColorsData testDataObject) {

        List<String> actualValues = getActualResultBlockValues();

        List<String> expectedValues =
                extractExpectedValues(testDataObject);

        //assertThat(actualValues,is(equalTo(expectedValues)));
        assertThat(actualValues, containsInAnyOrder(expectedValues.toArray()));
    }

    private List<String> extractExpectedValues(MetalsAndColorsData testData) {
        List<String> expectedValues = new ArrayList<>();

        int result = 0;
        for (String summaryData : testData.getSummary()) {
            result += Integer.valueOf(summaryData);
        }
        expectedValues.add(String.format("%s%s"
                , ResultOptions.SUMMARY.getOption(),
                String.valueOf(result)));

        StringJoiner elements = new StringJoiner(", ");
        for (CheckboxForces elementsData : testData.getElements()) {
            elements.add(elementsData.getForce());
        }
        expectedValues.add(String.format("%s%s"
                , ResultOptions.ELEMENTS.getOption(), elements));

        StringJoiner colors = new StringJoiner(", ");
        for (DropdownColors colorsData : testData.getColors()) {
            colors.add(colorsData.getColor());
        }
        expectedValues.add(String.format("%s%s"
                , ResultOptions.COLOR.getOption(), colors));

        StringJoiner metals = new StringJoiner(", ");
        for (RadioMetals metalsData : testData.getMetals()) {
            metals.add(metalsData.getMetal());
        }
        expectedValues.add(String.format("%s%s"
                , ResultOptions.METAL.getOption(), metals));

        StringJoiner vegetables = new StringJoiner(", ");
        for (Vegetables vegetableData : testData.getVegetables()) {
            vegetables.add(vegetableData.getVegetable());
        }
        expectedValues.add(String.format("%s%s"
                , ResultOptions.VEGETABLES.getOption(), vegetables));
        return expectedValues;
    }

    private List<String> getActualResultBlockValues() {
        List<String> actualValues = new ArrayList<>();
        actualValues.add(findResultBlockByOption(ResultOptions.SUMMARY)
                .getText());
        actualValues.add(findResultBlockByOption(ResultOptions.ELEMENTS)
                .getText());
        actualValues.add(findResultBlockByOption(ResultOptions.COLOR)
                .getText());
        actualValues.add(findResultBlockByOption(ResultOptions.METAL)
                .getText());
        actualValues.add(findResultBlockByOption(ResultOptions.VEGETABLES)
                .getText());
        return actualValues;
    }
    // !TODO
}
