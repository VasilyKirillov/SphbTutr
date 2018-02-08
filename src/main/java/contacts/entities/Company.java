package contacts.entities;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Company extends Contact {
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Office> offices;

    public Company() {
    }

    public Company(Set<Office> offices, String name) {
        super(name);
        this.offices = offices;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
    
}