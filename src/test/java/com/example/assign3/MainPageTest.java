package com.example.assign3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.headless = true;
        Configuration.timeout = 60;
    }

    Blog blog=new Blog();

    @Test
    public void CreatBlogTest() {
        String Title="Test Title ABC";
        String Desctiption="Tests Description ABC";
        String Markdown="Test Markdown PQR";

        String actualTitle=blog.createBlog(Title,Desctiption,Markdown);
        assertEquals(Title, actualTitle);

    }

    @Test
    public void ReadBlogTest() {

        boolean read_flag=blog.readBlog();
        assertEquals(read_flag, true);
    }

    @Test
    public void EditBlogTest() {

        String x="Edited";

        boolean testflag=blog.EditBlog(x);
        assertEquals(testflag, true);
    }

    @Test
    public void ViewAllArticlesTest() {


        boolean viewflag=blog.viewAllArticles();
        assertEquals(viewflag, true);
    }

    @Test
    public void DeleteBlogTest() {


        boolean deleteflag=blog.deleteBlog();
        assertEquals(deleteflag, true);
    }
    




}
