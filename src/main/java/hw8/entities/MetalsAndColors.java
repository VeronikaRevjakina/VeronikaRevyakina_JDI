package hw8.entities;

import hw8.enums.Colors;
import hw8.enums.Forces;
import hw8.enums.Metals;
import hw8.enums.Vegetables;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.stream.Collectors.toList;

@Getter
@Setter
@AllArgsConstructor
public class MetalsAndColors {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public String[] asArray() {
        return new String[]{
                format("Summary: %s", summary.stream().mapToInt(Integer::intValue).sum()),
                format("Elements: %s", join(", ", getElements())),
                format("Color: %s", color),
                format("Metal: %s", metals),
                format("Vegetables: %s", join(", ", getVegetables()))
        };
    }
}
