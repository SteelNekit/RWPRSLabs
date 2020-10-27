package client;

import server.entities.Shop;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        Registry registry = LocateRegistry.getRegistry("localhost");
        Shop stub = (Shop) registry.lookup("myShop");

        System.out.println("Average solded items: "+stub.AverageSoldedItems());
    }
}
