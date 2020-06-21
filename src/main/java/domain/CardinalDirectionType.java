/*
 * Copyright (c) 2020
 */
package domain;

import lombok.Getter;

@Getter
public enum CardinalDirectionType {
    N("Norte"),
    S("Sur"),
    W("Occidente"),
    E("Oriente");

    private final String description;

    CardinalDirectionType(String description) {
        this.description = description;
    }
}
