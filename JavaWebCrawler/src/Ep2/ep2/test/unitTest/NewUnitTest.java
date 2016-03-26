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
    private final String url = "https://www.linkedin.com/in/jeff-dean-8b212555?authType=NAME_SEARCH&authToken=pk4s&locale=en_US&trk=tyah&trkInfo=clickedVertical%3Amynetwork%2CclickedEntityId%3A194389190%2CauthType%3ANAME_SEARCH%2Cidx%3A1-1-1%2CtarId%3A1458952191027%2Ctas%3Ajeff%20dean";

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
        Domain domain = new Domain ("1234-124", url);

        Anchor anchor = new Anchor(domain,"1234-124",url);

        WebPage webPage = new WebPage(anchor);

        webPage.loadDocumentFromWeb();
        System.out.println("---> web page display : \n" +  webPage.getDocument());
        assertTrue(webPage.getDocument() != null );

    }
}
