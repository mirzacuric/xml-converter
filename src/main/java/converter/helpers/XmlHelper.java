package converter.helpers;

import converter.persistance.model.People;
import converter.persistance.model.Person;
import converter.persistance.model.XmlPeopleElement;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

@Service
public class XmlHelper {

  public String convertPeopleToXml(List<Person> persons)
  {
    People people = new People();
    people.setPerson(persons);
    XmlPeopleElement xmlElement = new XmlPeopleElement();
    xmlElement.setPeople(people);

    String result = "";

    try
    {
      JSONObject jsonObject = new JSONObject(xmlElement);
      String xml = XML.toString(jsonObject);
      result = formatXml(xml);
    } catch (Exception e) {
      e.getMessage();
    }
    return result;
  }

  public String formatXml (String xmlString) {
    try {
      Source xmlInput = new StreamSource(new StringReader(xmlString));
      StringWriter stringWriter = new StringWriter();
      StreamResult xmlOutput = new StreamResult(stringWriter);
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      transformerFactory.setAttribute("indent-number", 2);
      Transformer transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.transform(xmlInput, xmlOutput);
      return xmlOutput.getWriter().toString();
    } catch (Exception e) {
      throw new RuntimeException(e); // simple exception handling, please review it
    }
  }
}
