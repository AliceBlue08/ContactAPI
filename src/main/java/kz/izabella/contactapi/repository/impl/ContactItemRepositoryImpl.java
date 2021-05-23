package kz.izabella.contactapi.repository.impl;

import kz.izabella.contactapi.model.Contact;
import kz.izabella.contactapi.model.ContactItem;
import kz.izabella.contactapi.exception.ContactItemNotFoundException;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.model.ContactItemRequest;
import kz.izabella.contactapi.repository.ContactItemJPARepository;
import kz.izabella.contactapi.repository.ContactItemRepository;
import kz.izabella.contactapi.repository.ContactJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactItemRepositoryImpl implements ContactItemRepository {
    @Autowired
    ContactItemJPARepository contactItemJPARepository;
    @Autowired
    ContactJPARepository contactJPARepository;

    @Override
    public List<ContactItem> list(int contactId) throws ContactNotFoundException {
        contactJPARepository.findById(contactId)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
        List<ContactItem> items = contactItemJPARepository.findByContact_Id(contactId);
        return items;
    }

    @Override
    public ContactItem create(int contactId, ContactItemRequest request) throws ContactNotFoundException {
        Contact contact = contactJPARepository.findById(contactId)
                .orElseThrow(()-> new ContactNotFoundException("Contact not found"));
        ContactItem item = new ContactItem(contact, request.getContactItemType(), request.getValue());
        ContactItem contactItem = contactItemJPARepository.save(item);
        return contactItem;
    }

    @Override
    public ContactItem get(Integer id) throws ContactItemNotFoundException {
        ContactItem contactItem = contactItemJPARepository.findById(id)
                .orElseThrow(()-> new ContactItemNotFoundException("Contact Item not found"));
        return contactItem;
    }

    @Override
    public ContactItem update(Integer id, ContactItemRequest request) throws ContactItemNotFoundException {
        ContactItem contactItemToUpdate = contactItemJPARepository
                .findById(id)
                .orElseThrow(() -> new ContactItemNotFoundException("Contact Item not found"));
        contactItemToUpdate.setContactItemType(request.getContactItemType());
        contactItemToUpdate.setValue(request.getValue());
        ContactItem updatedItemContact = contactItemJPARepository.save(contactItemToUpdate);
        return updatedItemContact;
    }

    @Override
    public void delete(Integer id) throws ContactItemNotFoundException {
        ContactItem contactItemToDelete = contactItemJPARepository
                .findById(id)
                .orElseThrow(() -> new ContactItemNotFoundException("Contact Item not found"));
        contactItemJPARepository.delete(contactItemToDelete);
    }
}
