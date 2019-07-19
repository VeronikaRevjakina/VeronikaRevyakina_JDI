package hw7.entities;

import hw7.enums.CheckboxForces;
import hw7.enums.DropdownColors;
import hw7.enums.RadioMetals;
import hw7.enums.Vegetables;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum MetalsAndColorsData {

    DATA(Arrays.asList("3", "8"),
            Arrays.asList(CheckboxForces.WATER, CheckboxForces.FIRE),
            Arrays.asList(DropdownColors.RED), Arrays.asList(RadioMetals.SELEN),
            Arrays.asList(Vegetables.CUCUMBER,
                    Vegetables.TOMATO));

    private List<String> summary;
    private List<CheckboxForces> elements;
    private List<DropdownColors> colors;
    private List<RadioMetals> metals;
    private List<Vegetables> vegetables;
}
