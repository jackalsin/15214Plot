package Ep2.ep2.test.unitTest;

import Ep2.Anchor;
import Ep2.Domain;
import Ep2.WebPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by jacka on 3/25/2016.
 */
public class NewUnitTest {

    /**
     * Set up environment.
     */
    @Before
    public void setUp() {

    }

    /**
     * Test of loadDocument
     */
    @Test
    public void testLoadDocumentFromWeb() {
        Domain domain = new Domain ("1234-124", "http://www.jsoup.org");

        Anchor anchor = new Anchor(domain,"1234-124","http://www.jsoup.org");

        WebPage webPage = new WebPage(anchor);

        webPage.loadDocumentFromWeb();
        System.out.println("Before println");
        System.out.println("webPage.getDocument() != null : " +  webPage.getDocument());
        assertTrue(webPage.getDocument() != null );

    }
}
