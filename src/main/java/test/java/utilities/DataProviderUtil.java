package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {


    @DataProvider
    public Object[][] provinceDatas() {
        return new Object[][]{
                {"Ankara","MiddleAnatolia","06"},
                {"Izmir","Ege ","35"},
                {"Diyarbakir","SouthEast","21"}};
    }

    @DataProvider
    public Object[][] province() {
        return new Object[][]{};
    }
}
