package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readEcelFile(String fileName) {
        File excelFile = new File(System.getProperty("user.dir")+ "/testData/" +fileName);
        //XLSX file
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        Row row;
        Cell emailAddressCell, passwordCell;
        User user;
        List<User> userList = null;
        try {
            xssfWorkbook = new XSSFWorkbook(excelFile);
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            Iterator<Row> rowIterable =xssfSheet.iterator();
            userList = new ArrayList<User>();
            while (rowIterable.next()!=null){
                row = rowIterable.next();
                emailAddressCell =row.getCell(0);
                passwordCell =row.getCell(1);
                user = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);
                xssfWorkbook.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
