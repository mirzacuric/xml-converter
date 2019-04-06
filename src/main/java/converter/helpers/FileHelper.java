package converter.helpers;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileHelper {
  public String readFileContent (MultipartFile file) {
    BufferedReader br;
    List<String> result = new ArrayList<>();
    try {

      String line;
      InputStream is = file.getInputStream();
      br = new BufferedReader(new InputStreamReader(is));
      while ((line = br.readLine()) != null) {
        result.add(line);
      }

    } catch (IOException e) {
      System.out.println(e.getMessage());
      return "";
    }
    return result.toString().replace("[","").replace("]","");
  }
}
