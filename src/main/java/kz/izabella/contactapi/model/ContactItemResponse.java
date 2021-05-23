package kz.izabella.contactapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ContactItemResponse {
    @Getter
    private Integer Id;
    @Getter
    private String contactItemType;
    @Getter
    private String value;
}
