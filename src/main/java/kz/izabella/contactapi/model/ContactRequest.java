package kz.izabella.contactapi.model;

import lombok.Getter;

public class ContactRequest {
    @Getter
    private int id;
    @Getter
    private String fullName;
    @Getter
    private String job;
}
