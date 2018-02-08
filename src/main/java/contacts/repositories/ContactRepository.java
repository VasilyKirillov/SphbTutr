package contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import contacts.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
