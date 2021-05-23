package kz.izabella.contactapi.repository;

import kz.izabella.contactapi.model.ContactItem;
import kz.izabella.contactapi.exception.ContactItemNotFoundException;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.model.ContactItemRequest;

import java.util.List;

public interface ContactItemRepository {
    List<ContactItem> list(int contactId) throws ContactNotFoundException;
    ContactItem create(int contactId, ContactItemRequest contact) throws ContactNotFoundException;
    ContactItem get(Integer id) throws ContactItemNotFoundException;
    ContactItem update(Integer id, ContactItemRequest contact) throws ContactItemNotFoundException;
    void delete(Integer id) throws ContactItemNotFoundException;
}
