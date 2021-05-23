package kz.izabella.contactapi.model;

import lombok.Getter;

public class ContactItemRequest {
    @Getter
    private String contactItemType;
    @Getter
    private String value;
}
