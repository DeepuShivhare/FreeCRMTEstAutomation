package com.crm.qa.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.crm.qa.base.TestBase.driver;

public class TestUtil
{
    public static Object[][] getDataFromSheet(int sheetNo) {
        Object[][] data = new Object[0][];
        try {
            File src = new File("D:\\TestData.xlsx");

            FileInputStream fis = new FileInputStream(src);

            XSSFWorkbook wb = new XSSFWorkbook(fis);

            //XSSFSheet sheet = wb.getSheetAt(0); //LogIn_DataDriven
            XSSFSheet sheet = wb.getSheetAt(sheetNo); //ContactsDataDriven

            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

            for (int i = 0; i < sheet.getLastRowNum(); i++) {

                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                    //System.out.println(data[i][j]);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException
    {
        File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir=System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir+"/screenshot/"+System.currentTimeMillis()+".png"));

    }
}
