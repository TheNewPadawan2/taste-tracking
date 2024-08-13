package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransferDTO {
    private BatchDTO batch;
    private SiteDTO from;
    private SiteDTO to;
    private Date shippingDate;
    private Date acquiredDate;
}

