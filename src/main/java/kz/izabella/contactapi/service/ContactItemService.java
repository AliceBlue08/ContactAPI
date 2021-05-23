package kz.izabella.contactapi.service;

import kz.izabella.contactapi.model.ContactItem;
import kz.izabella.contactapi.exception.ContactItemNotFoundException;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.model.ContactItemRequest;
import kz.izabella.contactapi.model.ContactItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactItemService {
    List<ContactItemResponse> getContactItems(int contactId) throws ContactNotFoundException;
    ContactItemResponse createContactItem(int contactId, ContactItemRequest contact) throws ContactNotFoundException;
    ContactItemResponse getContactItemById(Integer id) throws ContactItemNotFoundException;
    ContactItemResponse updateContactItemById(Integer id, ContactItemRequest contact) throws ContactItemNotFoundException;
    void deleteContactItemById(Integer id) throws ContactItemNotFoundException;
}
