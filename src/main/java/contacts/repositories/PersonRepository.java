package contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import contacts.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
