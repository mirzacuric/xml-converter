package converter.persistance.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "born", "address", "phone" })
public class Family {

  private String name;
  private String born;
  private Address address;
  private Phone phone;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBorn() {
    return born;
  }

  public void setBorn(String born) {
    this.born = born;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Phone getPhone() {
    return phone;
  }

  public void setPhone(Phone phone) {
    this.phone = phone;
  }
}
