package com.nttdata.bff_bank.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class ProductDTO {

    private String id;
    private String clientId;
    private String type;
    private String accountType;
    private String activeType;
    private String accountNumber;
    private Double amount;
    private Date createdAt;

}