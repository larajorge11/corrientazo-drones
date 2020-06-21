/*
 * Copyright (c) 2020
 */
package domain;

import lombok.Getter;

@Getter
public enum CardinalDirection {
    N("Norte"),
    S("Sur"),
    W("Occidente"),
    E("Oriente");

    private final String description;

    CardinalDirection(String description) {
        this.description = description;
    }
}
