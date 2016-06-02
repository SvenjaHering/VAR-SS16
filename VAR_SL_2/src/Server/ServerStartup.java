package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerStartup {

    public static void main(String[] args) throws RemoteException {
        if (System.getSecurityManager() == null) {

            // Policy einbinden
            System.setProperty("java.security.policy", "java.policy");

            System.setSecurityManager(new SecurityManager());
            System.out.println("Security Manager wurde eingerichtet");
        } else {
            System.out.println("Security Manager konnte nicht eingerichtet werden");
        }

        // RMI Registry einbinden auf "Standard-Port" REGISTRY_POST = 1099
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

        String name = "//" + args[0] + "/PI";
        try {
            Server server = new Server();
            Naming.rebind(name, server);
        } catch (Exception e) {
            System.err.println("Server Exception" + e.getMessage());
            e.printStackTrace();
        }
    }
}
