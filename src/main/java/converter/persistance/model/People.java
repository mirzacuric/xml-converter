package converter.persistance.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class People {

  private List<Person> person;

  @XmlElement
  public List<Person> getPerson() {
    return person;
  }

  public void setPerson(List<Person> person) {
    this.person = person;
  }
}
