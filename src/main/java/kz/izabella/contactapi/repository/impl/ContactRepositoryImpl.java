package kz.izabella.contactapi.repository.impl;

import kz.izabella.contactapi.model.Contact;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.exception.FullNameMustBeAlphabeticException;
import kz.izabella.contactapi.model.ContactRequest;
import kz.izabella.contactapi.repository.ContactJPARepository;
import kz.izabella.contactapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

    @Autowired
    @Lazy
    private ContactJPARepository contactJPARepository;

    @Override
    public List<Contact> list() {
        return contactJPARepository.findAll();
    }

    @Override
    public Contact get(Integer id) throws ContactNotFoundException {
        Contact contact = contactJPARepository
                .findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
        return contact;
    }

    @Override
    public Contact create(ContactRequest contact) throws FullNameMustBeAlphabeticException {
        if (contact.getFullName() != null
                && !contact.getFullName().equals("")
                && contact.getFullName().matches("^[a-zA-Z ]*$")) {
            return contactJPARepository.save(new Contact(contact.getId(), contact.getFullName(), contact.getJob()));
        }
        throw new FullNameMustBeAlphabeticException("FullName must contain only alphabets!");
    }

    @Override
    public Contact update(Integer id, ContactRequest contact) throws ContactNotFoundException {
        Contact contactToUpdate = contactJPARepository
                .findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
        contactToUpdate.setFullName(contact.getFullName());
        contactToUpdate.setJob(contact.getJob());
        Contact updatedContact = contactJPARepository.save(contactToUpdate);
        return updatedContact;
    }

    @Override
    public void delete(Integer id) throws ContactNotFoundException {
        Contact contactToDelete = contactJPARepository
                .findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
        contactJPARepository.delete(contactToDelete);
    }
}
