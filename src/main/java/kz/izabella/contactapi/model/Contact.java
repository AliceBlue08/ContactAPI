package kz.izabella.contactapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "job")
    private String job;
    @OneToMany(mappedBy = "contact", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ContactItem> contactItems;


    public Contact() {
    }

    public Contact(int id, String fullName, String job) {
        this.id = id;
        this.fullName = fullName;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<ContactItem> getContactItems() {
        return contactItems;
    }

    public void setContactItems(List<ContactItem> contactItems) {
        this.contactItems = contactItems;
    }
}
