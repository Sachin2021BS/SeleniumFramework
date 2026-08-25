package com.ui.dataproviders;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LoginDataProvider {

    @DataProvider(name= "LoginDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir")+"/testData/logindata.json");
        FileReader fileReader = new FileReader(testDataFile);
        TestData testData = gson.fromJson(fileReader, TestData.class);
        List<Object[]> dataToReturn = new ArrayList<Object[]>();

        for (User user: testData.getData()){
            dataToReturn.add(new Object[]{user});
        }

        return dataToReturn.iterator();
    }


}
