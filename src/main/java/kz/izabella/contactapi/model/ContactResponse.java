package kz.izabella.contactapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private String job;
}
