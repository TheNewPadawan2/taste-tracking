package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

@Data
public class SiteDTO {
    private String idEanUcc;
    private SiteType description;
    private String address;
    private String addressLine2;
    private int postalCode;
    private String city;
    private String country;
    private FirmDTO firm;
}
