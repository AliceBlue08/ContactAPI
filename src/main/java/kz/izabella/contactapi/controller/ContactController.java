package kz.izabella.contactapi.controller;
import kz.izabella.contactapi.model.Contact;
import kz.izabella.contactapi.exception.ContactNotFoundException;
import kz.izabella.contactapi.exception.FullNameMustBeAlphabeticException;
import kz.izabella.contactapi.model.ContactRequest;
import kz.izabella.contactapi.model.ContactResponse;
import kz.izabella.contactapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getContacts() {
        try {
            List<ContactResponse> contacts = contactService.getContacts();
            return ResponseEntity.ok(contacts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getContact(@PathVariable("id") int contactId) {
        try {
            ContactResponse contact = contactService.getContactById(contactId);
            return ResponseEntity.ok(contact);
        } catch (ContactNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addContact(@RequestBody ContactRequest contact) {
        try {
            ContactResponse response = contactService.createContact(contact);
            return ResponseEntity.ok(response);
        } catch (FullNameMustBeAlphabeticException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Contact wasn't added: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateContact(@PathVariable int id, @RequestBody ContactRequest contact) {
        try {
            ContactResponse updatedContact = contactService.updateContactById(id, contact);
            return ResponseEntity.ok(updatedContact);
        } catch (ContactNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Contact wasn't updated: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable int id) {
        try {
            contactService.deleteContactById(id);
            return ResponseEntity.ok("Contact was deleted");
        } catch (ContactNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Contact wasn't deleted: " + e.getMessage());
        }
    }
}
