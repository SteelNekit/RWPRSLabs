package client;

import server.entities.Shop;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException {
        Shop shop = setConnection("localhost", "myShop");
        if (shop == null) {
            System.out.println("Server down");
        } else {
            System.out.println("Average solded items: " + shop.AverageSoldedItems());
        }
    }

    public static Shop setConnection(String url, String name) {
        try {
            Registry registry = LocateRegistry.getRegistry(url,1099);
            Shop shop = (Shop) registry.lookup("myShop");
            shop.isAlive();
            return shop;
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
