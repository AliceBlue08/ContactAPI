package kz.izabella.contactapi.controller;

import kz.izabella.contactapi.exception.ContactItemNotFoundException;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.exception.FullNameMustBeAlphabeticException;
import kz.izabella.contactapi.model.Contact;
import kz.izabella.contactapi.model.ContactItem;
import kz.izabella.contactapi.model.ContactItemRequest;
import kz.izabella.contactapi.model.ContactItemResponse;
import kz.izabella.contactapi.service.ContactItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactItemController {

    @Autowired
    private ContactItemService contactItemService;

    @RequestMapping(value = "/{id}/items/all", method = RequestMethod.GET)
    public ResponseEntity getContactItems(@PathVariable("id") int contactId) {
        try {
            List<ContactItemResponse> items = contactItemService.getContactItems(contactId);
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public ResponseEntity getContact(@PathVariable("id") int contactItemId) {
        try {
            ContactItemResponse item = contactItemService.getContactItemById(contactItemId);
            return ResponseEntity.ok(item);
        } catch (ContactItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @RequestMapping(value = "{id}/items", method = RequestMethod.POST)
    public ResponseEntity addContact(@PathVariable("id") int contactId, @RequestBody ContactItemRequest request) {
        try {
            ContactItemResponse response = contactItemService.createContactItem(contactId, request);
            return ResponseEntity.ok(response);
        } catch (ContactNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Contact wasn't added: " + e.getMessage());
        }
    }

    @RequestMapping(value = "items/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateContact(@PathVariable int id, @RequestBody ContactItemRequest request) {
        try {
            ContactItemResponse response = contactItemService.updateContactItemById(id, request);
            return ResponseEntity.ok(response);
        } catch (ContactItemNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Contact wasn't updated: " + e.getMessage());
        }
    }

    @RequestMapping(value = "items/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable int id) {
        try {
            contactItemService.deleteContactItemById(id);
            return ResponseEntity.ok("Contact was deleted");
        } catch (ContactItemNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Contact wasn't deleted: " + e.getMessage());
        }
    }
}