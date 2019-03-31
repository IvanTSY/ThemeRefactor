package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex5 extends CoreTestCase {



    @Test

    public void testSaveFirstArticleToMyList(){

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);

        String search_line = "java";
        String name_of_folder = "Learning";
        String search_line_second = "Appium";


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clicByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject.waitForTitleElement();
        String title_article = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line_second);
        SearchPageObject.clicByArticleWithSubstring(search_line_second);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addSecondArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI.clickMyList();
        MyListsPageObject.openFolderByName(name_of_folder);


        MyListsPageObject.swipeByArticleToDelete(title_article);
        SearchPageObject.waitForEmptySearchResult(title_article);
        SearchPageObject.waitForSearchResult(search_line_second);
        SearchPageObject.clicByArticleWithSubstring(search_line_second);

        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Wrong article or not find appium article in state",
                search_line_second,
                article_title
        );

    }

}
