package kz.izabella.contactapi.repository;

import kz.izabella.contactapi.model.ContactItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactItemJPARepository extends JpaRepository<ContactItem, Integer> {
    List<ContactItem> findByContact_Id(Integer id);
}
