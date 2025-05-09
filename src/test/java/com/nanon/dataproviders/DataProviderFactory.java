package com.nanon.dataproviders;

import com.nanon.helpers.ExcelHelper;
import com.nanon.helpers.SystemHelper;
import com.nanon.utils.LogUtils;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "data_provider_login_excel")
    public Object[][] dataLoginFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelDataProvider(SystemHelper.getCurrentDir() + "src/test/resources/testdata/CMS.xlsx", "LoginDataProvider");
        LogUtils.info("Login Data from Excel: "+data);
        return data;
    }


    @DataProvider(name = "data_provider_login_success", parallel = true)
    public Object[][] dataProviderLoginSuccess() {
        return new Object[][]{
                {"admin123@example.com", "123456"}
        };
    }
    @DataProvider(name="data_provider_login_hashtable")
    public Object[][] dataLoginFromExcelHashtable(){
        ExcelHelper excelHelper=new ExcelHelper();
        Object[][] data=excelHelper.getExcelDataHashTable(SystemHelper.getCurrentDir()+"src/test/resources/testdata/CMS.xlsx","Login",1,1);
        LogUtils.info("Login Daat from Excel Hashtable: "+data);
        return data;
    }

}