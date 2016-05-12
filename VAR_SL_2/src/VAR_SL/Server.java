package VAR_SL;
import java.math.BigDecimal;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Server extends UnicastRemoteObject implements RMI {

	protected Server() throws RemoteException {
		super();
	}

	@Override
	public BigDecimal berechnePI() throws RemoteException {
		PI pi = new PI();
		return pi.berechnePI();
	}

}
