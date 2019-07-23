package hw7.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw7.entities.MetalsAndColors;
import hw7.enums.Colors;
import hw7.enums.Forces;
import hw7.enums.Metals;
import hw7.enums.Vegetables;

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
        selectColorsByEnumValue(metalsAndColors.getColor());
        selectForcesCheckboxByEnumValue(metalsAndColors.getElements());
        selectMetalsByEnumValue(metalsAndColors.getMetal());
        selectVegetablesByEnumValue(metalsAndColors.getVegetables());
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

    private void selectForcesCheckboxByEnumValue(List<Forces> forces) {
        for (Forces force : forces) {
            forcesCheckbox.select(force.getForce());
        }
    }

    private void selectColorsByEnumValue(Colors color) {
        colorsDropdown.select(color.getColor());
    }

    private void selectMetalsByEnumValue(Metals metal) {
        metalsDropdown.select(metal.getMetal());
    }

    private void selectVegetablesByEnumValue(List<Vegetables> vegetables) {
        vegetablesDropdown.select(Vegetables.VEGETABLES.getVegetable());
        for (Vegetables vegetable : vegetables) {
            vegetablesDropdown.select(vegetable.getVegetable());
        }
    }
}
