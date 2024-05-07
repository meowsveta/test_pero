package com.example.demo;

import org.openqa.selenium.By;

// page_url = https://vk.com/club225299895?w=product-225299895_10044406

public class ProductPage {
    public By writeBtn = By.cssSelector(".vkuiButton.vkuiButton--appearance-accent");
    public By copyLinkBtn = By.xpath("//*[contains(@data-action-name, 'copyUrl')]");
    public By favoriteBtn = By.xpath("//*[contains(@data-action-name, 'favorite')]");
    public By wishListBtn = By.xpath("//*[contains(@data-action-name, 'wishlist')]");
    public By shareBtn = By.xpath("//*[contains(@data-action-name, 'share')]");
    public By likeBtn = By.xpath("//*[contains(@data-action-name, 'like')]");
    public By redLikeBtn = By.cssSelector(".ItemActions__itemIcon--hovered, .ItemActions__itemIcon--selected, .ItemActions__itemIcon--liked, .ItemActions__itemTextDropdown:hover");
}