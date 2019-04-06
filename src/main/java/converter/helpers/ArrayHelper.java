package converter.helpers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArrayHelper {
  public ArrayList<String> convertArrayStringToArrayList (String[] oldArray) {
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < oldArray.length; i++) {
      list.add(oldArray[i]);
    }
    return list;
  }
}
