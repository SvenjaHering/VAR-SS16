package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote {
    public long berechneTropfenImKreis(long precision) throws RemoteException;
}
