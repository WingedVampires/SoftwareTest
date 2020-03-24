package com.lsc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MoneyProviderTest {

    private int input;
    private boolean expected;
    private MoneyProvider moneyProvider = null;

    public MoneyProviderTest(boolean expected, int input) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        moneyProvider = new MoneyProvider();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {false, -1},
                {true, 0},
                {true, 3},
                {false, 4},
                {true, 93},
                {false, 94}
        });
    }


    @Test
    public void afford() {
        assertEquals(this.expected, moneyProvider.afford(input));
    }
}