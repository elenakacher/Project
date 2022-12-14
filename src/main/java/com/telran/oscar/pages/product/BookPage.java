package com.telran.oscar.pages.product;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;

public class BookPage extends BasePage {
    public BookPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(xpath = "//div[@class='col-sm-6 product_main']/h1")
    WebElement bookTitle;

    public String getBookTitel() {
        return bookTitle.getText();
    }

    @FindBy(xpath = "//li[@class = 'breadcrumb-item']/a[1]")
    WebElement homeLink;

    public AllProductsPage clickOnHomeLink() {
        click(homeLink);
        return new AllProductsPage(wd);
    }

    public boolean isBookTitelPresent() {
        return bookTitle.isDisplayed();
    }

    @FindBy(css = ".col-sm-6.product_main>.price_color")
    WebElement price;

    public boolean isPricePresent() {
        return price.isDisplayed();
    }

    @FindBy(css = ".col-sm-6.product_main>.instock")
    WebElement inStock;

    public boolean isInStockPresent() {
        return inStock.isDisplayed();
    }

    @FindBy(css = ".breadcrumb")
    WebElement breadcrumbs;

    public boolean isBreadcumbsPresent() {
        return breadcrumbs.isDisplayed();
    }

    @FindBy(id = "product_description")
    WebElement productDescription;

    public boolean isProductDescriptionPresent() {
        return productDescription.isDisplayed();
    }

    @FindBy(xpath = "//div[@class = 'sub-header'][2]")
    WebElement productInformation;

    public boolean isProductInformationPresent() {
        return productInformation.isDisplayed();
    }

    @FindBy(id = "reviews")
    WebElement customerReviews;

    public boolean isCustomerReviewsPresent() {
        return customerReviews.isDisplayed();
    }

    @FindBy(xpath = "//h2[contains(text(),'Products you recently viewed')]")
    WebElement productsYouRecentlyViewed;

    public boolean isProductsYouRecentlyViewedPresent() {
        jumpDown();
        return productsYouRecentlyViewed.isDisplayed();
    }

    private void verifyLinks(String linkUrl) {
        URL url = null;
        // create url-connection and get status code
        try {
            url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() +
                        " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " is a broken link");
        }
    }

    @FindBy(tagName = "img")
    WebElement image;

    public boolean isPicturePresent() {
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);

            // check to display image with JS executor
            boolean imageDisplayed = (Boolean) ((JavascriptExecutor) wd).executeScript(
                    "return (typeof arguments[0].naturalWidth != undefined " +
                            "&& arguments[0].naturalWidth > 0);", image);
            if (imageDisplayed) return true;
            else return false;
        }

    @FindBy(id = "write_review")
    WebElement writeReviewBtn;

    @FindBy(id = "id_title")
    WebElement reviewTitelField;

    @FindBy(xpath = "//div[@class ='star-rating ']//i[4]")
    WebElement starRating;

    @FindBy(id = "id_body")
    WebElement bodyField;

    @FindBy(id = "id_name")
    WebElement nameField;

    @FindBy(id = "id_email")
    WebElement emailField;

    @FindBy(xpath = "//button[@class = 'btn btn-primary btn-lg']")
    WebElement saveBtn;

    @FindBy(xpath = "//a[contains(text(),'cancel')]")
    WebElement cancelBtn;

    public BookPage writeReview(String title, String body) {
        click(writeReviewBtn);
        type(reviewTitelField, title);
        click(starRating);
        type(bodyField, body);
        click(saveBtn);
        return this;
    }

    @FindBy(xpath = "//a[contains(text(), 'customer review')]")
    WebElement displayedReview;

    public boolean isReviewDisplayed() {
        return displayedReview.isDisplayed();
    }

    public boolean isSaveBtnDisplayed() {
        return saveBtn.isDisplayed();
    }

    public BookPage writeReviewWithoutRating(String title, String body) {
        click(writeReviewBtn);
        type(reviewTitelField, title);
        type(bodyField, body);
        click(saveBtn);
        return this;
    }

    public BookPage writeReviewUnloggedUser(String title, String body, String name, String email) {
        click(writeReviewBtn);
        type(reviewTitelField, title);
        click(starRating);
        type(bodyField, body);
        type(nameField, name);
        type(emailField, email);
        click(saveBtn);
        return this;
    }

    public BookPage writeReviewWithoutRatingUnloggedUser(String title, String body, String name, String email) {
        click(writeReviewBtn);
        type(reviewTitelField, title);
        type(bodyField, body);
        type(nameField, name);
        type(emailField, email);
        click(saveBtn);
        return this;
    }

    @FindBy(xpath = "//button[@class = 'btn btn-lg btn-primary w-100']")
    WebElement addToBasketBtn;

    public BookPage addToBasketTest() {
        click(addToBasketBtn);
        return this;
    }
    @FindBy(css = ".fade.show:nth-child(1) > div.alertinner")
    WebElement confirmMsg;

    public String confirmMessageText() {
        return confirmMsg.getText();
    }

    @FindBy(css = ".alertinner > a.btn.btn-info:nth-child(4)")
    WebElement checkoutBtn;

    public boolean isCheckoutNowBtnAppeared() {
        return checkoutBtn.isDisplayed();
    }

    public BookPage addToWishListTest() {
        return this;
    }

}

