package com.lutfi.stepdef;

import com.lutfi.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks extends BaseTest{

    @Before
    public void beforetest(){
       getDriver();
    }

    @After
    public void aftertest(){
        driver.close();
    }

}
