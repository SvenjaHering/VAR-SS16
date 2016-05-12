package VAR_SL;

import java.math.BigDecimal;
import java.rmi.Naming;

public class ServerStartup {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null)
			;
		{
			System.setSecurityManager(new SecurityManager());
		}
		String name = "//" + args[0] + "/PI";
		try {
			Server s = (Server) Naming.lookup(name);
			BigDecimal pi = s.berechnePI(); // habe keinen noch keinen Parameter
											// (int precision)
			System.out.println(pi);
		} catch (Exception e) {
			System.err.println("Client Exception" + e.getMessage());
			e.printStackTrace();
		}
	}
}
