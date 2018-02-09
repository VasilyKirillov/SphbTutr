
package contacts.entities.representation;

import contacts.entities.Person;



public class PersonRepresentation {
    
    private final String name;
    private final AddressRepresentation address;

    public PersonRepresentation(Person person) {
        this.name = person.getName();
        this.address = new AddressRepresentation(person.getAddress());
    }

    public String getName() {
        return name;
    }

    public AddressRepresentation getAddress() {
        return address;
    }
    
    
}
