package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

@Data
public class MeasureDTO {
    private MeasureType type = MeasureType.WEIGHT;
    private double value;
}
