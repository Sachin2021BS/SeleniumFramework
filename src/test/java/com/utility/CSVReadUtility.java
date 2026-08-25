package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CSVReadUtility {

    public static Iterator<User> readCSVFile(String fileName) {
        File csvFile = new File(System.getProperty("user.dir") + "/testData/"+fileName);
        FileReader fileReader = null;
        CSVReader csvReader = null;
        String[] data;
        User userData;
        List<User> userlist;
        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();// Reading the col Names --- Row 1 Skip the colNames
            userlist = new ArrayList<User>();

            while((data = csvReader.readNext())!= null){
                userData = new User(data[0], data[1]);
                userlist.add(userData);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return userlist.iterator();
    }


}
