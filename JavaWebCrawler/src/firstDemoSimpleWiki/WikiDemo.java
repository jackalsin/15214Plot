package firstDemoSimpleWiki;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the simple demo of java web crawler
 *
 * Created by jacka on 3/25/2016.
 */
public class WikiDemo {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.jsoup.org/").get();
            org.jsoup.select.Elements newsHeadLines = doc.select("a");
            for (Element e : newsHeadLines) {
                System.out.println(e.attr("abs:href"));
            }
        } catch (IOException e)  {
            Logger.getLogger(WikiDemo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
