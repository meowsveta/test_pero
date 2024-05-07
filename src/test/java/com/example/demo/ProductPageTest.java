package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductPageTest {
    ProductPage productPage= new ProductPage();
    MainPageCommunity mainPageCommunity = new MainPageCommunity();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895?w=product-225299895_10044406");
    }

    @Test
    public void search() throws InterruptedException {
        Thread.sleep(1_000);
    }

    @DisplayName("Проверка кнопки \"Написать\"")
    @Test
    public void buttonWriteCLick() {
        $(productPage.writeBtn).click();
        $(By.xpath("//*[@data-testid = 'box_layout']")).shouldBe(Condition.visible);
    }

    @DisplayName("Проверка кнопки \"Копировать ссылку\"")
    @Description("Должно всплывать окно -\"Ссылка успешно скопирована\"")
    @Test
    public void buttonCopyCLick() {
        $(By.id("notifiers_wrap")).shouldNot(Condition.visible);
        $(productPage.copyLinkBtn).click();
        $(By.id("notifiers_wrap")).shouldBe(Condition.visible);
    }

    @DisplayName("Проверка кнопки \"В закладки\"")
    @Test
    public void buttonFavouriteCLick() {
        $(productPage.favoriteBtn).shouldHave(Condition.text("В закладки")).click();
        $(productPage.favoriteBtn).shouldHave(Condition.text("В закладках"));
    }

    @DisplayName("Проверка видимости всех элементов на странице")
    @Test
    public void visibleTest() {
        $(By.className("vkuiSimpleCell__content")).shouldBe(Condition.visible);
        $(By.linkText("Test public for test")).shouldBe(Condition.visible);
        $(By.className("ItemName")).shouldBe(Condition.visible);
        $(".MarketItemCard__price").shouldBe(Condition.visible);
    }

    @DisplayName("Проверка правильности названия сообщества в карточке товара")
    @Test
    public void pageNameTest(){
        Assertions.assertEquals("Test public for test", $(mainPageCommunity.pageName).text());
    }

    @DisplayName("Проверка перехода на кнопку названия сообщества в карточке товара")
    @Test
    public void pageCommunityBtn(){
        $(By.linkText("Test public for test")).click();
        Assertions.assertEquals(webdriver().driver().getWebDriver().getCurrentUrl(), "https://vk.com/club225299895");
    }

    @DisplayName("Проверка кнопки \"В желания\"")
    @Test
    public void buttonWishListClick() {
        $(productPage.wishListBtn).shouldHave(Condition.text("В желания")).click();
        $(productPage.wishListBtn).shouldHave(Condition.text("В желаниях"));
    }

    @DisplayName("Проверка кнопки \"Поделиться\"")
    @Test
    public void buttonShareClick() {
        $(productPage.shareBtn).click();
        $(productPage.shareBtn).shouldBe(Condition.visible);
    }

    @DisplayName("Проверка кнопки like")
    @Test
    public void buttonLikeClick() {
        $(productPage.redLikeBtn).shouldNot(Condition.visible);
        $(productPage.likeBtn).shouldBe(Condition.visible).click();
        $(productPage.redLikeBtn).shouldBe(Condition.visible);
    }
}
