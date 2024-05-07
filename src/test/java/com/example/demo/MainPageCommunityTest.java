package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageCommunityTest {
    MainPageCommunity mainPageCommunity = new MainPageCommunity();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895");
    }

    @Test
    public void search() throws InterruptedException {
        Thread.sleep(1_000);
    }

    @DisplayName("Проверка видимости всех элементов на странице")
    @Test
    public void visibleTest(){
        $(mainPageCommunity.pageName).shouldBe(Condition.visible);
        $(mainPageCommunity.avatar).shouldBe(Condition.visible);
        $(mainPageCommunity.subscribeBtn).shouldHave(Condition.text("Подписаться")).shouldBe(Condition.visible);
        $(mainPageCommunity.subscribers).shouldHave(Condition.text("Костя")).shouldBe(Condition.visible);
        $(mainPageCommunity.services).shouldHave(Condition.text("Услуги")).shouldBe(Condition.visible);
    }
}
