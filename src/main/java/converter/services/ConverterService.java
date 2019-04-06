package converter.services;

import converter.helpers.DataHelper;
import converter.helpers.FileHelper;
import converter.helpers.StringHelper;
import converter.helpers.XmlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import converter.persistance.model.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterService {

  @Autowired
  FileHelper fileHelper;

  @Autowired
  StringHelper stringHelper;

  @Autowired
  DataHelper dataHelper;

  @Autowired
  XmlHelper xmlHelper;

    public String convertToXml(MultipartFile file) {
      String xmlResult = "";
      List<Person> people = new ArrayList<>();
      try {
        String content = fileHelper.readFileContent(file);
        List<String> personsString = stringHelper.splitStringByPattern(content, "\\,\\s(?=P\\|)");
        for(String item : personsString){
          Person person = dataHelper.personInformation(item);
          people.add(person);
        }
        xmlResult = xmlHelper.convertPeopleToXml(people);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      return xmlResult;
    }
}
