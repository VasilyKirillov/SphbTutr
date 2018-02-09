package contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) /*  InheritanceType.SINGLE_TABLE not garantee uniqe ids for each child and parent */
public abstract class Contact extends UrlEntity {    

    @Column(columnDefinition = "VARCHAR(20) default 'GOD'")
    private String name;

    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
