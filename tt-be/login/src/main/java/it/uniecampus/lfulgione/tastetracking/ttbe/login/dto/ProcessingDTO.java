package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ProcessingDTO {
    private ProductDTO from;
    private ProductDTO to;
    private Date startDate = new Date();
    private Date endDate;
    private boolean endDatePredicted = true;
    private String description;
    private String serviceMessage;
    private List<MeasureDTO> measuresFrom = new ArrayList<>(1);
    private List<MeasureDTO> measuresTo = new ArrayList<>(1);
}
