package VAR_SL;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.math.*;

public interface RMI extends Remote {
public BigDecimal berechnePI() throws RemoteException;
}
