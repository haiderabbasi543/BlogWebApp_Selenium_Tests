package com.example.assign3;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
public class Blog {

    public String createBlog(String x,String y, String z) {


        open("http://3.144.37.216:41960");
        //click start a new discussion button
       
        $(By.xpath("/html/body/div/a")).click();
        $(By.id("title")).setValue(x);
        $(By.id("description")).setValue(y);
        $(By.id("markdown")).setValue(z);
        $(By.xpath("/html/body/div/form/button")).click();
        $(By.xpath("/html/body/div/a[1]")).click();
        String Text1=$(By.xpath("/html/body/div/div[1]/div/h4")).getText();
        $(By.xpath("/html/body/div/div/div/form/button")).click();
        webdriver().driver().clearCookies();
        return Text1;

    }

    public boolean readBlog() {
        
        open("http://3.144.37.216:41960");
        String Title_Before=$(By.xpath("/html/body/div/div[1]/div/h4")).getText();
        $(By.xpath("/html/body/div/div[1]/div/a[1]")).click();
        String Title_After=$(By.xpath("/html/body/div/h1")).getText();
        if(Title_Before.equals(Title_After)) {
            webdriver().driver().clearCookies();
            return true;
        }
        else {
            webdriver().driver().clearCookies();
            return false;
        }
    }

    public boolean EditBlog(String x){
        
        open("http://3.144.37.216:41960");
        $(By.xpath("/html/body/div/a")).click();
        $(By.id("title")).setValue("Blog to be edited");
        $(By.id("description")).setValue("Description EE");
        $(By.id("markdown")).setValue("Markdown EE");
        $(By.xpath("/html/body/div/form/button")).click();
        $(By.xpath("/html/body/div/a[1]")).click();


        $(By.xpath("/html/body/div/div[1]/div/a[2]")).click();

        $(By.id("title")).clear();
        $(By.id("title")).setValue(x+" Title");
        String Text2=$(By.id("description")).getText();
        $(By.id("description")).clear();
        $(By.id("description")).setValue(x+Text2);
        String Text3=$(By.id("markdown")).getText();
        $(By.id("markdown")).clear();
        $(By.id("markdown")).setValue(x+Text3);
        $(By.xpath("/html/body/div/form/button")).click();

        String after=$(By.xpath("/html/body/div/h1")).getText();

        $(By.xpath("/html/body/div/a[1]")).click();
        $(By.xpath("/html/body/div/div/div/form/button")).click();
        if(after.equals(x+" Title")) {
            webdriver().driver().clearCookies();
            return true;

        }
        else {
            return false;

        }

    }

    public boolean deleteBlog() {

        
        open("http://3.144.37.216:41960");
        $(By.xpath("/html/body/div/a")).click();
        $(By.id("title")).setValue("Blog to be deleted");
        $(By.id("description")).setValue("Description D");
        $(By.id("markdown")).setValue("Markdown M");
        $(By.xpath("/html/body/div/form/button")).click();
        $(By.xpath("/html/body/div/a[1]")).click();
        String Text1=$(By.xpath("/html/body/div/div[1]/div/h4")).getText();

        String Before=$(By.xpath("/html/body/div/div[1]/div/h4")).getText();
        $(By.xpath("/html/body/div/div/div/form/button")).click();
        String After=$(By.xpath("/html/body/div/div[1]/div/h4")).getText();
        if(!Before.equals(After)) {
            webdriver().driver().clearCookies();
            return true;
        }
        else {
            webdriver().driver().clearCookies();
            return false;
        }
    }

    public boolean viewAllArticles() {

        open("http://3.144.37.216:41960");

        $(By.xpath("/html/body/div/a")).click();
        $(By.id("title")).setValue("SampleH");
        $(By.id("description")).setValue("SampleL");
        $(By.id("markdown")).setValue("SampleZ");
        $(By.xpath("/html/body/div/form/button")).click();
        $(By.xpath("/html/body/div/a[1]")).click();

        String After=$(By.xpath("/html/body/div/div[1]/div/h4")).getText();
        $(By.xpath("/html/body/div/div/div/form/button")).click();

        if(After.equals("SampleH")) {
            webdriver().driver().clearCookies();
            return true;
        }
        else {
            webdriver().driver().clearCookies();
            return false;
        }


    }

}
