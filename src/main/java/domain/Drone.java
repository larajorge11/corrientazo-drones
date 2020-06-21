/*
 * Copyright (c) 2020
 */
package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Drone {

    private String identification;
    private GeographicalPosition geographicalCurrentPosition;
    private List<List<String>> commands;
    @Setter
    private List<GeographicalPosition> geographicalPositionsDelivery;
}
