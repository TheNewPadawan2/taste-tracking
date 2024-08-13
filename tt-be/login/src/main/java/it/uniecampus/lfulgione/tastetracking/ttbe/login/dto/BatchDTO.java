package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BatchDTO {
    private ProductDTO product;
    private FirmDTO firm;
    private String description;
    private Date creationDate = new Date();
    private String serviceMessage;
    private List<MeasureDTO> measures = new ArrayList<>(1); //Use to be only weight
}
