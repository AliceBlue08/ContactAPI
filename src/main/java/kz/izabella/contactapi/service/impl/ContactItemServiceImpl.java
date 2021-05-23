package kz.izabella.contactapi.service.impl;

import kz.izabella.contactapi.model.ContactItem;
import kz.izabella.contactapi.exception.ContactItemNotFoundException;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.model.ContactItemRequest;
import kz.izabella.contactapi.model.ContactItemResponse;
import kz.izabella.contactapi.repository.ContactItemRepository;
import kz.izabella.contactapi.service.ContactItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactItemServiceImpl implements ContactItemService {
    @Autowired
    private ContactItemRepository contactItemRepository;

    @Override
    public List<ContactItemResponse> getContactItems(int contactId) throws ContactNotFoundException {
        List<ContactItem> list = contactItemRepository.list(contactId);
        List<ContactItemResponse> response = new ArrayList<ContactItemResponse>();
        list.forEach(i -> response.add(new ContactItemResponse(i.getId(), i.getContactItemType(), i.getValue())));
        return response;
    }

    @Override
    public ContactItemResponse createContactItem(int contactId, ContactItemRequest contact) throws ContactNotFoundException {
        ContactItem item = contactItemRepository.create(contactId, contact);
        return new ContactItemResponse(item.getId(), item.getContactItemType(), item.getValue());
    }

    @Override
    public ContactItemResponse getContactItemById(Integer id) throws ContactItemNotFoundException {
        ContactItem item = contactItemRepository.get(id);
        return new ContactItemResponse(item.getId(), item.getContactItemType(), item.getValue());
    }

    @Override
    public ContactItemResponse updateContactItemById(Integer id, ContactItemRequest contact) throws ContactItemNotFoundException {
        ContactItem item = contactItemRepository.update(id, contact);
        return new ContactItemResponse(item.getId(), item.getContactItemType(), item.getValue());
    }

    @Override
    public void deleteContactItemById(Integer id) throws ContactItemNotFoundException {
        contactItemRepository.delete(id);
    }
}
