package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    --wee need to create an object from properties class. bu object ile stream a alinan file path i
    properties.load.(fis) methodu ile properties file daki datas i load eder and propeerties file daki
    key value yi return edilir.

     */

  static Properties properties;

  static{                                                //STATIC BLOCK ILE BEFOER METHOD GIBI METHODLARDAN ONCE CALISIR,
                                                            //YER ISGAL ETMMEMESI ICIN

      String filePath="configuration.properties";
      try {
          FileInputStream fis = new FileInputStream(filePath);

          properties=new Properties();

          properties.load(fis);//fis in okudugu bilgileri properties e load eder

      } catch (IOException e) {
          throw new RuntimeException(e);
      }

  }

  public static String getProperty(String key)  {

    String value=properties.getProperty(key);//String girilen key in value yi return eder
      return value;
  }
}
