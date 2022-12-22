package com.crm.qa.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader
{
    public static  void main(String args[])
    {
        try {
        File src=new File("D:\\TestData.xlsx");

        FileInputStream fis=new FileInputStream(src);

            XSSFWorkbook wb=new XSSFWorkbook(fis);

            XSSFSheet sh1= wb.getSheetAt(0);

            System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());

            System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());

            System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());

            System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());

            System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());

            System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }


//        //get all rows in the sheet
//        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
//
//        //iterate over all the row to print the data present in each cell.
//        for(int i=0;i<=rowCount;i++){
//
//            //get cell count in a row
//            int cellcount=sheet.getRow(i).getLastCellNum();
//
//            //iterate over each cell to print its value
//            System.out.println("Row"+ i+" data is :");
//
//            for(int j=0;j<cellcount;j++){
//                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
//            }
//            System.out.println();
//        }
    }
}