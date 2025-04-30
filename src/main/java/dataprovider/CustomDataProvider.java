package dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "readexcelData")
    public Object[][] getdata(){
//        String filePath = "/testdata/TestData.xlsx";
        String filePath = ConfigReader.getValue("testdatafilepath");
        String sheetName = ConfigReader.getValue("sheetname");
        return ExcelReader.readXlData(filePath, sheetName);
    }
}
