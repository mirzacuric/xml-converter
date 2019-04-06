package converter.helpers;

import converter.persistance.model.Address;
import converter.persistance.model.Family;
import converter.persistance.model.Person;
import converter.persistance.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataHelper {

  @Autowired
  StringHelper stringHelper;

  public Person personInformation (String personDetailsString) {
    Person person = new Person(){};
    List<Family> personFamilies = new ArrayList<Family>();
    List<String> familiesFromString = stringHelper.splitStringByPattern(personDetailsString, "\\,\\s(?=F\\|)");
    for (int i = 0; i < familiesFromString.size(); i++) {
      if (familiesFromString.get(i).contains("P|")) {
        person = getPersonDetails(person, familiesFromString.get(i));
      } else if (familiesFromString.get(i).contains("F|")) {
        Family family = getFamily(familiesFromString.get(i));
        personFamilies.add(family);
      }
    }
    if (personFamilies.size() > 0) {
      person.setFamily(personFamilies);
    }
    return person;
  }

  public Person getPersonDetails (Person person, String personDetailsString) {
    List<String> personDetails = stringHelper.splitStringByPattern(personDetailsString, "\\,\\s(?=A|T)");
    for (int i = 0; i < personDetails.size(); i++) {
      if (personDetails.get(i).contains("P|")) {
        String cleanString = personDetails.get(i).replace("P|", "");
        List<String> name = stringHelper.splitStringByPattern(cleanString, "(\\|)");
        for (int j = 0; j < name.size(); j++) {
          switch (j) {
            case 0:
              person.setFirstname(name.get(0));
              break;
            case 1:
              person.setLastname(name.get(1));
              break;
          }
        }
      } else if (personDetails.get(i).contains("A|")) {
        Address address = getAddress(personDetails.get(i));
        person.setAddress(address);
      } else if (personDetails.get(i).contains("T|")) {
        Phone phone = getPhone(personDetails.get(i));
        person.setPhone(phone);
      }
    }
    return person;
  }

  public Address getAddress (String addressString) {
    Address a = new Address(){};
    String cleanAddressString = addressString.replace("A|", "");
    List<String> address = stringHelper.splitStringByPattern(cleanAddressString, "(\\|)");
    for (int i = 0; i < address.size(); i++) {
      switch (i) {
        case 0:
          a.setStreet(address.get(0));
          break;
        case 1:
          a.setCity(address.get(1));
          break;
        case 2:
          a.setZipCode(address.get(2));
          break;
      }
    }
    return a;
  }

  public Phone getPhone (String phoneString) {
    Phone p = new Phone(){};
    String cleanPhoneString = phoneString.replace("T|", "");
    List<String> phone = stringHelper.splitStringByPattern(cleanPhoneString, "(\\|)");
    for (int i = 0; i < phone.size(); i++) {
      switch(i) {
        case 0:
          p.setMobile(phone.get(0));
          break;
        case 1:
          p.setLandLine(phone.get(1));
          break;
      }
    }
    return p;
  }

  public Family getFamily (String familyDetailsString) {
    Family f = new Family(){};
    List<String> familyDetails = stringHelper.splitStringByPattern(familyDetailsString, "\\,\\s(?=A|T)");
    for (int i = 0; i < familyDetails.size(); i++) {
      if (familyDetails.get(i).contains("F|")) {
        String cleanString = familyDetails.get(i).replace("F|", "");
        List<String> family = stringHelper.splitStringByPattern(cleanString, "(\\|)");
        for (int j = 0; j < family.size(); j++) {
          switch (j) {
            case 0:
              f.setName(family.get(0));
              break;
            case 1:
              f.setBorn(family.get(1));
              break;
          }
        }
      } else if (familyDetails.get(i).contains("A|")) {
        Address address = getAddress(familyDetails.get(i));
        f.setAddress(address);
      } else if (familyDetails.get(i).contains("T|")) {
        Phone phone = getPhone(familyDetails.get(i));
        f.setPhone(phone);
      }
    }
    return f;
  }
}
