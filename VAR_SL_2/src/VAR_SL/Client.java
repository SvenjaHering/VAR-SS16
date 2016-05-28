package VAR_SL;

import java.math.BigDecimal;
import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "//" + args[0] + "/PI";
            Server s = (Server) Naming.lookup(name);
            int precision = 0; // TODO noch falsch!!! soll dynamisch übergeben werden
            BigDecimal pi = s.berechnePI(precision);
            System.out.println(pi);

        } catch (Exception e) {
            System.err.println("Client Exception" + e.getMessage());
            e.printStackTrace();

        }
    }

    // TODO Methode in main integrieren
    public void berechnePI() {
        // double anzahl = (anzahlInnerhalb / (anzahlAusserhalb + anzahlInnerhalb)) * 4; // TODO HELP! wird hier PI genähert??

        // BigDecimal value = new BigDecimal(anzahl);

    }
}