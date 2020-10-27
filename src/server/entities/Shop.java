package server.entities;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Shop extends Remote {
    Employee GetMostCoolEmployee() throws RemoteException;
    double AverageSoldedItems() throws RemoteException;
    void inFile() throws IOException, RemoteException;
}
