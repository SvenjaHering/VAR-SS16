package VAR_SL;

import java.math.BigDecimal;
import java.rmi.Naming;

public class Client {

    // Anzahl der Zufallszahlen, die berechnet werden sollen
    public static final long PRECISION = 2000000;

    public static void main(String[] args) {

        if (System.getSecurityManager() == null) {

            // Policy einbinden
            System.setProperty("java.security.policy", "java.policy");

            System.setSecurityManager(new SecurityManager());
            System.out.println("Security Manager wurde eingerichtet");
        } else {
            System.out.println("Security Manager konnte nicht eingerichtet werden");
        }

        try {
            String name = "//" + args[0] + "/PI";
            RMI rmi = (RMI) Naming.lookup(name);

            long anzahlTropfenImKreis = rmi.berechneTropfenImKreis(PRECISION);
            BigDecimal pi = berechnePI(anzahlTropfenImKreis);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("Client Exception" + e.getMessage());
            e.printStackTrace();
        }
    }

    // TODO Formel noch fehlerhaft
    public static BigDecimal berechnePI(long anzahlTropfenImKreis) {
        return new BigDecimal((anzahlTropfenImKreis / ((PRECISION - anzahlTropfenImKreis) + anzahlTropfenImKreis)) * 4);
    }

}