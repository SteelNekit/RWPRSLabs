import org.xml.sax.SAXException;
import server.entities.ShopImpl;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        ShopImpl shop = new ShopImpl();
        System.out.println("В среднем за день продано: "+shop.AverageSoldedItems());
    }
}
