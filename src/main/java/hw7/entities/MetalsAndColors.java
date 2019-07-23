package hw7.entities;

import hw7.enums.Colors;
import hw7.enums.Forces;
import hw7.enums.Metals;
import hw7.enums.Vegetables;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.stream.Collectors.toList;

@Getter
@AllArgsConstructor
public enum MetalsAndColors {

    DATA(
            Arrays.asList(3, 8),
            Arrays.asList(Forces.WATER, Forces.FIRE),
            Colors.RED,
            Metals.SELEN,
            Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO)
    );

    private List<Integer> summary;
    private List<Forces> elements;
    private Colors color;
    private Metals metal;
    private List<Vegetables> vegetables;

    public String[] asArray() {
        return new String[]{
                format("Summary: %s", summary.stream().mapToInt(Integer::intValue).sum()),
                format("Elements: %s", join(", ", getElementsAsStrings())),
                format("Color: %s", color.getColor()),
                format("Metal: %s", metal.getMetal()),
                format("Vegetables: %s", join(", ", getVegetablesAsStrings()))
        };
    }

    private List<String> getVegetablesAsStrings() {
        return vegetables.stream()
                .map(Vegetables::getVegetable)
                .collect(toList());
    }

    private List<String> getElementsAsStrings() {
        return elements.stream()
                .map(Forces::getForce)
                .collect(toList());
    }
}
