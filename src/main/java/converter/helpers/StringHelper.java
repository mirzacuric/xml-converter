package converter.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StringHelper {

  @Autowired
  ArrayHelper arrayHelper;

  public List<String> splitStringByPattern (String str, String pattern) {
    String[] arrOfStr = str.split(pattern);
    return  arrayHelper.convertArrayStringToArrayList(arrOfStr);
  }
}