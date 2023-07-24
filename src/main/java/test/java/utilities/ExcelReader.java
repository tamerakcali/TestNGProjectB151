package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    Workbook wb;
    Sheet sheet;

    public ExcelReader(String filePath,String pageName) {

        try {
            FileInputStream fis=new FileInputStream(filePath);
            wb=WorkbookFactory.create(fis);
            sheet=wb.getSheet(pageName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
  //  row and cell number enter edildiginde, that, cell deki datayi return eden method.

   public String getCellData(int row, int column ){

        Cell cell =sheet.getRow(row).getCell(column);
        return cell.toString();
 //excel deki cell sayisini return eden method;

    }
    public int rowNum() {
        return sheet.getLastRowNum();

   }

}
