package utils;

import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excel {
    public static List<String> readExelFile(String fileName) {
        FileInputStream inStream = null;
        XSSFWorkbook workbook = null;
        List<String>lines=new ArrayList<String>();
        try {
            inStream = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(inStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIter = sheet.rowIterator();
            while (rowIter.hasNext()) {
                Row row = (Row) rowIter.next();
                Iterator<Cell> cellIter =  row.cellIterator();
                lines.add( cellIter.next().toString());
            }
            workbook.close();
            inStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
