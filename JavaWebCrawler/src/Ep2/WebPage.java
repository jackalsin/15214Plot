package Ep2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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


    public void loadDocumentFromWeb() {
        try {
            document = Jsoup.connect(anchor.getAnchorURL()).get();
//            org.jsoup.select.Elements newsHeadLines = document.select("a");
//            for (Element e : newsHeadLines) {
//                System.out.println(e.attr("abs:href"));
//            }
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



