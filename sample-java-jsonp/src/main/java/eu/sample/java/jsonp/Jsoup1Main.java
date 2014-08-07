package eu.sample.java.jsonp;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Jsoup1Main {

    public static void main(String[] args) throws IOException {
        String html = "<div><h3>abc</h3><strong>def</strong></div>";
        Document document = Jsoup.parse(html);
        System.out.println(document.text());
        System.out.println(document.text().length());
    }
}