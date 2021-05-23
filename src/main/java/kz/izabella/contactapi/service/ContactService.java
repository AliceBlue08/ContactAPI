package kz.izabella.contactapi.service;

import kz.izabella.contactapi.model.Contact;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.exception.FullNameMustBeAlphabeticException;
import kz.izabella.contactapi.model.ContactRequest;
import kz.izabella.contactapi.model.ContactResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    List<ContactResponse> getContacts();
    ContactResponse createContact(ContactRequest contact) throws FullNameMustBeAlphabeticException;
    ContactResponse getContactById(Integer id) throws ContactNotFoundException;
    ContactResponse updateContactById(Integer id, ContactRequest contact) throws ContactNotFoundException;
    void deleteContactById(Integer id) throws ContactNotFoundException;
}
