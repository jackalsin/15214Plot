package Ep4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jacka on 3/25/2016.
 */
public class WebPage {

    private Anchor anchor;
    private String webPageHash;
    private int anchorParseStatus;
    private int emailParseStatus;

    private Document document;
    /**
     * The constructor that with anchor as its args
     *
     * @param anchor
     */
    public WebPage(Anchor anchor) {
        this.anchor = anchor;
    }


    /**
     * It load the page to the from the web
     */
    public void loadDocumentFromWeb() {
        try {
            document = Jsoup.connect(anchor.getAnchorURL()).get();
        } catch (IOException e)  {
            Logger.getLogger(WebPage.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Document getter.
     * Document getter.
     * @return Document
     */
    public Document getDocument() {
        return document;
    }

}



