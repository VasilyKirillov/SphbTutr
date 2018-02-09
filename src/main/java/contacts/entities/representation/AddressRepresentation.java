package contacts.entities.representation;

import contacts.entities.Address;

public class AddressRepresentation {

    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public AddressRepresentation(Address address) {
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

}
