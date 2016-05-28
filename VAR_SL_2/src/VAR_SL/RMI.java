package VAR_SL;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote {
    public BigDecimal berechnePI(int precision) throws RemoteException;
}
