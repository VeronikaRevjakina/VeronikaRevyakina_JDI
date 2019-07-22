package hw7.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw7.entities.MetalsAndColorsData;
import hw7.enums.CheckboxForces;
import hw7.enums.DropdownColors;
import hw7.enums.RadioMetals;
import hw7.enums.Vegetables;

import java.util.List;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

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

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist metalsDropdown;

    @JDropdown(root = "div[ui=droplist]",
            list = "li",
            expand = ".caret")
    private Droplist vegetablesDropdown;

    public void selectSummaryByValue(List<String> values) {
        for (String value : values) {
            if (Integer.valueOf(value) % 2 == 0) {
                summaryEven.select(value);
            } else {
                summaryOdd.select(value);
            }
        }
    }

    public void selectForcesCheckboxByEnumValue(List<CheckboxForces> forces) {
        for (CheckboxForces force : forces) {
            forcesCheckbox.select(force.getForce());
        }
    }

    public void selectColorsByEnumValue(List<DropdownColors> colors) {
        for (DropdownColors color : colors) {
            colorsDropdown.select(color.getColor());
        }
    }

    public void selectVegetablesByEnumValue(List<Vegetables> vegetables) {
        vegetablesDropdown.select(Vegetables.VEGETABLES.getVegetable());
        for (Vegetables vegetable : vegetables) {
            vegetablesDropdown.select(vegetable.getVegetable());
        }
    }

    public void selectMetalsByEnumValue(List<RadioMetals> metals) {
        for (RadioMetals metal : metals) {
            metalsDropdown.select(metal.getMetal());
        }
    }
}
