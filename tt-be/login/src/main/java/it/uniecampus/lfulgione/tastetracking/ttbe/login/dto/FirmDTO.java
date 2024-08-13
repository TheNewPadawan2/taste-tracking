package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FirmDTO {
    private String idEanUcc;
    private String companyName;
    private List<SiteDTO> sites = new ArrayList<>(2); //Min: Stock + Product sites
    private String email;
    private String certificateMail;
    private String phoneNumber;
}
