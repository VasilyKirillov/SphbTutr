package contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import contacts.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
