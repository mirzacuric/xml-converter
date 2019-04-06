package converter.persistance.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "firstname", "lastname", "phone", "address", "family" })
public class Person {

    private String firstname;
    private String lastname;
    private Phone phone;
    private Address address;
    private List<Family> family;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Family> getFamily() {
        return family;
    }

    public void setFamily(List<Family> family) {
        this.family = family;
    }
}
