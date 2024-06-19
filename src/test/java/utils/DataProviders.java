package utils;

import java.io.File;
import org.testng.annotations.DataProvider;

public class DataProviders {

  @DataProvider
  public Object[] getResponseSchema() {
    File[] data = new File[1];
    data[0] = new File(
        System.getProperty("user.dir") + "/src/test/resources/JsonSchema/getResponse.json");
    return data;

  }

  @DataProvider
  public Object[] getSingleResponseSchema() {
    File[] data = new File[1];
    data[0] = new File(
        System.getProperty("user.dir") + "/src/test/resources/JsonSchema/getSingleResponse.json");
    return data;
  }

}
