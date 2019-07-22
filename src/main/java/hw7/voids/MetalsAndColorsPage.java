package hw7.voids;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import hw7.entities.MetalsAndColorsData;
import hw7.enums.*;
import hw7.forms.MetalsAndColorsForm;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

public class MetalsAndColorsPage extends WebPage {

    // TODO This element should belongs to the form.--Fixed

    @Css("ul[class='panel-body-list results'] ")
    private UIElement resultBlock;


    private MetalsAndColorsForm metalsAndColorsForm;

    public UIElement findResultBlockByOption(String option) {
        return resultBlock.find
                (By.xpath(".//li[contains(string(),'" + option + "')]"));
    }

    // TODO It will be better to encapsulate this calls to M______m. (fill the gap)--Skype??
    public void fillMetalsAndColorsForm(MetalsAndColorsData data) {
        metalsAndColorsForm.selectSummaryByValue(data.getSummary());
        metalsAndColorsForm.selectColorsByEnumValue(data.getColors());
        metalsAndColorsForm.selectForcesCheckboxByEnumValue(data.getElements());
        metalsAndColorsForm.selectMetalsByEnumValue(data.getMetals());
        metalsAndColorsForm.selectVegetablesByEnumValue(data.getVegetables());

        metalsAndColorsForm.clickSubmitMetalsAndColors();
    }


    // !TODO

    // TODO The certain sequence of log's rows doesn't matter in this case.--Skype
    // It will be easier to compare just two List<strings>
    // First list you can generate from MetalsAndColors instance
    // Second list can be generated from Log ui-element
    public void checkResultsBlockOutput(MetalsAndColorsData testDataObject) {
        if (testDataObject.getSummary() != null) {
            int result = 0;
            for (String summaryData : testDataObject.getSummary()) {
                result += Integer.valueOf(summaryData);
            }
            findResultBlockByOption(ResultOptions.SUMMARY.getOption())
                    .shouldBe()
                    .text(Matchers.containsString(String.valueOf(result)));
        }

        if (testDataObject.getElements() != null) {
            for (CheckboxForces elementsData : testDataObject.getElements()) {
                findResultBlockByOption(ResultOptions.ELEMENTS.getOption())
                        .shouldBe()
                        .text(Matchers.containsString(elementsData.getForce()));

            }
        }

        if (testDataObject.getColors() != null) {
            for (DropdownColors colorsData : testDataObject.getColors()) {
                findResultBlockByOption(ResultOptions.COLOR.getOption())
                        .shouldBe()
                        .text(Matchers.containsString(colorsData.getColor()));
            }
        }

        if (testDataObject.getMetals() != null) {
            for (RadioMetals metalsData : testDataObject.getMetals()) {
                findResultBlockByOption(ResultOptions.METAL.getOption())
                        .shouldBe()
                        .text(Matchers.containsString(metalsData.getMetal()));
            }
        }

        if (testDataObject.getVegetables() != null) {
            for (Vegetables vegetableData : testDataObject.getVegetables()) {
                findResultBlockByOption(ResultOptions.VEGETABLES.getOption())
                        .shouldBe()
                        .text(Matchers.containsString(vegetableData.getVegetable()));

            }
        }
        // !TODO
    }
}
