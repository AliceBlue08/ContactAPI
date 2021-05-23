package kz.izabella.contactapi.repository;

import kz.izabella.contactapi.model.Contact;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.exception.FullNameMustBeAlphabeticException;
import kz.izabella.contactapi.model.ContactRequest;

import java.util.List;

public interface ContactRepository {
    List<Contact> list();
    Contact create(ContactRequest contact) throws FullNameMustBeAlphabeticException;
    Contact get(Integer id) throws ContactNotFoundException;
    Contact update(Integer id, ContactRequest contact) throws ContactNotFoundException;
    void delete(Integer id) throws ContactNotFoundException;
}
