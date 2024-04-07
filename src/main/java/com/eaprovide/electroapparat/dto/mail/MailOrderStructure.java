package com.eaprovide.electroapparat.dto.mail;

import lombok.Data;

@Data
public class MailOrderStructure {
    private String Product;
    private String Price;
    private String surname;
    private String name;
    private String nameOfOrganization;
    private String inn;
    private String email;
    private String numberOfTelephone;
    private String address;
}
