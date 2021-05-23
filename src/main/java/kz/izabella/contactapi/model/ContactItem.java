package kz.izabella.contactapi.model;

import javax.persistence.*;

@Entity
@Table(name = "Contact_Items")
public class ContactItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;
    @Column(name = "contact_item_type")
    private String contactItemType;
    @Column(name = "value")
    private String value;

    public ContactItem() {
    }

    public ContactItem(Contact contact, String contactItemType, String value) {
        this.contact = contact;
        this.contactItemType = contactItemType;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getContactItemType() {
        return contactItemType;
    }

    public void setContactItemType(String contactItemType) {
        this.contactItemType = contactItemType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
