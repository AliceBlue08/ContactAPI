package kz.izabella.contactapi.service.impl;

import kz.izabella.contactapi.model.Contact;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.exception.FullNameMustBeAlphabeticException;
import kz.izabella.contactapi.model.ContactRequest;
import kz.izabella.contactapi.model.ContactResponse;
import kz.izabella.contactapi.repository.ContactRepository;
import kz.izabella.contactapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactResponse> getContacts() {
        List<Contact> contacts = contactRepository.list();
        List<ContactResponse> response = new ArrayList<>();
        contacts.forEach(c -> response.add(new ContactResponse(c.getId(), c.getFullName(), c.getJob())));
        return response;
    }

    @Override
    public ContactResponse createContact(ContactRequest request) throws FullNameMustBeAlphabeticException {
        Contact contact  = contactRepository.create(request);
        return  new ContactResponse(contact.getId(), contact.getFullName(), contact.getJob());
    }

    @Override
    public ContactResponse getContactById(Integer id) throws ContactNotFoundException {
        Contact contact = contactRepository.get(id);
        return  new ContactResponse(contact.getId(), contact.getFullName(), contact.getJob());
    }

    @Override
    public ContactResponse updateContactById(Integer id, ContactRequest request) throws ContactNotFoundException {
        Contact contact = contactRepository.update(id, request);
        return new ContactResponse(contact.getId(), contact.getFullName(), contact.getJob());
    }

    @Override
    public void deleteContactById(Integer id) throws ContactNotFoundException {
        contactRepository.delete(id);
    }
}