package com.nttdata.bff_bank.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClientDTO {

    private String id;
    private String dni;
    private String names;
    private String surnames;
    private String email;
    private String phone;
    private String type;

}