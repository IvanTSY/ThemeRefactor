package tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
public class Ex6 extends CoreTestCase {



    @Test

    public void testFindTitleWithoutTimeOut() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String search_line = "Appium";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clicByArticleWithSubstring(search_line);

        String attrib_for_search = ArticlePageObject.fastGetArticleTitle();

        assertEquals(
                "Wrong article or not find appium article in state",
                search_line,
                attrib_for_search
        );





    }

}
