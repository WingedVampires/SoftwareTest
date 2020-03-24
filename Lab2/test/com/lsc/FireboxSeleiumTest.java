package com.lsc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FireboxSeleiumTest {

    private List<List<String>> list;
    FireboxSeleium fireboxSeleium;
    String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";

    @Before
    public void setUp() throws Exception {
        list = ExcelUtil.getExcelData("src\\Selenium+Lab2020.xlsx");

        fireboxSeleium = new FireboxSeleium()
                .setBaseUrl(baseUrl)
                .load();
    }

    @After
    public void tearDown() throws Exception {
        fireboxSeleium.close();
    }



    @Test
    public void getAndJudgeResult() {
        for (List<String> i : list) {
            String result = fireboxSeleium.setUser(i.get(0), i.get(1)).GetAndJudgeResult();
            assertEquals(i.get(1), result);
        }
    }
}
