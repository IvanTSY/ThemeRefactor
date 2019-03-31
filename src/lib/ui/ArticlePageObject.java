package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static String TITLE = "org.wikipedia:id/view_page_title_text",
    OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "//*[@text='OK']",
    CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement(){
        return waitForElementPresent(By.id(TITLE),"Cannot find article title on page",15);
    }



    public String getArticleTitle(){
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public WebElement fastSearchTitleElement(){
        return waitForElementPresent(By.id(TITLE),"Cannot find article title on page",0);
    }



    public String fastGetArticleTitle(){
        WebElement title_element = fastSearchTitleElement();
        return title_element.getAttribute("text");
    }


    public void addArticleToMyList(String name_of_folder){
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Can not find menu",
                5
        );

        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Can not find element menu 'add'",
                5
        );

        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Con not find 'Got it'btn",
                5
        );

        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "can not find to clear text field",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "can not find input text field",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Can not find element menu 'add'",
                5
        );

    }

    public void addSecondArticleToMyList (String name_of_folder){
        this.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Can not find menu in second search",
                5
        );

        this.waitForElementPresent(
                By.xpath("//*[@text = 'Add to reading list']"),
                "Can not find element menu 'add'",
                5
        );

        this.waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='Add to reading list']"),
                "Can not find element menu 'add'",
                5
        );

        this.waitForElementAndClick(
                By.xpath("//*[@text='"+name_of_folder+"']"),
                "Can not add , by click on element'"+ name_of_folder +"'",
                5);


    }

    public void closeArticle(){
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Can not find close button",
                5
        );

        this.waitForElementNotPresent(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Can not invisible close button in second search appium",
                5
        );
    }


}
