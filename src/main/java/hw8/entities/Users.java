package hw8.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Users {

    PITER("epam", "1234", "PITER CHAILOVSKII");

    private final String login;
    private final String password;
    private final String fullName;
}
