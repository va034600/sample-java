package eu.sample.java.jdom;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JdomSample {
    public static void main(String[] args) throws Exception {
        Document doc = new SAXBuilder().build(new File("sample.xml"));
        Element root = doc.getRootElement();
        List<Element> allChildren = root.getChildren();
        Iterator<Element> iterator = allChildren.iterator();
        while (iterator.hasNext()) {
            Element student = (Element) iterator.next();
            System.out.println(student.getChild("age").getValue());
        }
    }
}