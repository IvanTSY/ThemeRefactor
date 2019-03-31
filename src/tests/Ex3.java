package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;


public class Ex3 extends CoreTestCase {



    @Test
    public void testFindSearch(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        String search_line = "java";

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForEmptyImageToAppear();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyImageToDisappear();
        SearchPageObject.waitClearSearchInput();
        SearchPageObject.waitForEmptyImageToAppear();

    }
}