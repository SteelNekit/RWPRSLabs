package server;

import org.xml.sax.SAXException;
import server.entities.Shop;
import server.entities.ShopImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws NamingException, IOException, SAXException, ParserConfigurationException {
        Shop shop = new ShopImpl();
        try{
            Shop stub = (Shop) UnicastRemoteObject.exportObject(shop,0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("myShop",stub);
            System.out.println("Complete");
        }catch (Throwable cause){
            System.err.println(cause.getMessage());
        }
    }
}
