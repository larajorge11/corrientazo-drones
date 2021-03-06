/*
 * Copyright (c) 2020
 */
package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Position {
    /**
     * Domain class for the position
     */
    private int positionX;
    private int positionY;
}
