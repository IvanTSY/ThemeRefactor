package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
        SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
        SEARCH_INPUT = "//*[contains(@text,'Search…')]",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
        SEARCH_EMPTY_IMAGE = "org.wikipedia:id/search_empty_image",
        CLEAR_SEARCH_BAR = "org.wikipedia:id/search_src_text";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }



    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }

//Поиск элемента и нажатие по нему , затем проверка
    public void initSearchInput(){
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find and click search init element",5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find search input after clicking search init element");
    }


    public void waitForEmptyImageToAppear(){
        this.waitForElementPresent(By.id(SEARCH_EMPTY_IMAGE),"Cannot find search cancel button",5);
    }

    public void waitForEmptyImageToDisappear(){
        this.waitForElementNotPresent(By.id(SEARCH_EMPTY_IMAGE),"Search cancel button is still present",5);
    }

    public void waitClearSearchInput(){
        this.waitForElementAndClear(By.id(CLEAR_SEARCH_BAR),"Search bar is not empty",5);
    }



    public void typeSearchLine(String search_line){
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT),search_line,"Cannot find and type into search input",5);
    }

    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),"Cannot find search result with substring"+substring);
    }

    public void waitForEmptySearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementNotPresent(By.xpath(search_result_xpath)," Article is not delete"+substring,10);
    }

    public void clicByArticleWithSubstring(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath),"Cannot find and click search result with substring"+substring,10);
    }


}


