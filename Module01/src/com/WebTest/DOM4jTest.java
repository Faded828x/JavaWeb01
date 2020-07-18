package com.WebTest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class DOM4jTest {
    @Test
    public void Dom4jTest() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src\\com\\WebTest\\XMLTest.xml");
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements("book");
        for (Element book : elements) {
            //方式1
            Element name = book.element("name");
            String text = name.getText();
            //方式2
            String author = book.elementText("author");
            String genre = book.elementText("genre");
            System.out.println(new book(text,genre,author));
        }
    }
}
