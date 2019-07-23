package hw8.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw8.entities.MetalsAndColors;
import hw8.enums.Vegetables;

import java.util.List;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Droplist colorsDropdown;

    @XPath("//*[@id='elements-checklist']//label[contains(text(), '%s')]")
    private UIElement forcesCheckbox;

    @Css("#odds-selector > p")
    private RadioButtons summaryOdd;

    @Css("#even-selector > p")
    private RadioButtons summaryEven;

    @Css("#submit-button")
    private Button submit;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist metalsDropdown;

    @JDropdown(root = "div[ui=droplist]",
            list = "li",
            expand = ".caret")
    private Droplist vegetablesDropdown;

    @Override
    public void submit(MetalsAndColors metalsAndColors) {
        selectSummaryByValue(metalsAndColors.getSummary());
        selectColorsByValue(metalsAndColors.getColor());
        selectForcesCheckboxByValue(metalsAndColors.getElements());
        selectVegetablesByValue(metalsAndColors.getVegetables());
        selectMetalsByValue(metalsAndColors.getMetals());
        submit.click();
    }

    private void selectSummaryByValue(List<Integer> values) {
        for (Integer value : values) {
            if (value % 2 == 0) {
                summaryEven.select(Integer.toString(value));
            } else {
                summaryOdd.select(Integer.toString(value));
            }
        }
    }

    private void selectForcesCheckboxByValue(List<String> forces) {
        for (String force : forces) {
            forcesCheckbox.select(force);
        }
    }

    private void selectColorsByValue(String color) {
        colorsDropdown.select(color);
    }

    private void selectMetalsByValue(String metal) {
        metalsDropdown.select(metal);
    }

    private void selectVegetablesByValue(List<String> vegetables) {
        vegetablesDropdown.select(Vegetables.VEGETABLES.getVegetable());
        for (String vegetable : vegetables) {
            vegetablesDropdown.select(vegetable);
        }
    }
}
