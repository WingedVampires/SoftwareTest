package com.lsc;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    public static List<List<String>> getExcelData(String path) {
        List<List<String>> list = new ArrayList<>();

        try {
            OPCPackage pkg = OPCPackage.open(path);
            XSSFWorkbook excel = new XSSFWorkbook(pkg);
            //获取第一个sheet
            XSSFSheet sheet0 = excel.getSheetAt(0);

            for (Iterator rowIterator = sheet0.iterator(); rowIterator.hasNext(); ) {
                XSSFRow row = (XSSFRow) rowIterator.next();
                String username = row.getCell(1).getStringCellValue();
                String password = row.getCell(2).getStringCellValue();

                if (username.equals("") && password.equals("")) {
                    break;
                } else {
                    list.add(new ArrayList<String>(Arrays.asList(username, password)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
