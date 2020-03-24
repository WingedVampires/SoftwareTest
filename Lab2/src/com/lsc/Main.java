package com.lsc;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";

        List<List<String>> list = ExcelUtil.getExcelData("src\\Selenium+Lab2020.xlsx");

        FireboxSeleium fireboxSeleium = new FireboxSeleium()
                .setBaseUrl(baseUrl)
                .load();

        for (List<String> i : list) {
            String result = fireboxSeleium.setUser(i.get(0), i.get(1)).GetAndJudgeResult();
            System.out.println("Username: " + i.get(0));
            System.out.println("Password: " + i.get(1));
            System.out.println("Data on the website: " + result);
            System.out.println("isEqual: " + i.get(1).equals(result));
            System.out.println();
        }

        fireboxSeleium.close();

    }



}
