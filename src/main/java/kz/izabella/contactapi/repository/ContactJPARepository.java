package kz.izabella.contactapi.repository;

import kz.izabella.contactapi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactJPARepository extends JpaRepository<Contact, Integer> {
}
