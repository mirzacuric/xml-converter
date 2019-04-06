package helpers;

import converter.helpers.StringHelper;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Helpers {

  StringHelper stringHelper = new StringHelper();

  @Test
  public void splitStringByPattern() {

    List<String> expected =  Arrays.asList("one", "two", "three");
    List<String> equal = stringHelper.splitStringByPattern("one, two, three", ",");
    List<String> notEqual = stringHelper.splitStringByPattern("four, five, six", ",");
    List<String> notSame = stringHelper.splitStringByPattern("two, one, three", ",");

    Assert.assertEquals("Equal", expected, equal);
    Assert.assertNotEquals("Not equal", expected, notEqual);
    Assert.assertNotSame("Not same", expected, notSame);
  }
}
