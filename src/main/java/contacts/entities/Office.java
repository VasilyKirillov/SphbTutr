
package contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Office  extends UrlEntity {
        
    @Column(nullable = false) /* means that the field "name" must not be NULL */ 
    private String name;
    
    @ManyToOne(optional = false) /* "optional = false" means that company must not be NULL */  
    private Company company;
    /* optional is used for OneToOne, OneToMany and ManyToOne, ManyToMany annotations */
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Address address;

    public Office() {
    }

    public Office(Address address, Company company, String name) {
        this.address = address;
        this.company = company;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }    
    
}
