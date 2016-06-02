package Client;

import java.math.BigDecimal;
import java.rmi.Naming;

import Server.RMI;

public class Client {

    // Anzahl der Berechnungen der Tropfen im Kreis
    public static final int WIEDERHOLUNGEN = 100;

    // Anzahl der Zufallszahlen, die berechnet werden sollen
    public static final int PRECISION = 1000000;

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

            System.out.println("PI wird berechnet...");

            // Hier werden die genäherten Pi-Werte aus der for-Schleife gespeichert
            BigDecimal[] piArray = new BigDecimal[WIEDERHOLUNGEN];

            // Berechnung von Pi anhand der Anzahl der Tropfen im Kreis
            for (int i = 0; i < WIEDERHOLUNGEN; i++) {
                long anzahlTropfenImKreis = rmi.berechneTropfenImKreis(PRECISION);
                piArray[i] = berechnePI(anzahlTropfenImKreis);
            }

            // Durchschnittberechnung der Pi-Werte
            BigDecimal piSumme = new BigDecimal(0);
            for (int i = 0; i < piArray.length; i++) {
                piSumme = piSumme.add(piArray[i]);
            }
            BigDecimal pi = piSumme.divide(new BigDecimal(WIEDERHOLUNGEN));
            System.out.println(pi);

        } catch (Exception e) {
            System.err.println("Client Exception" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Berechnet Pi anhand einer Anzahl von Tropfen im Kreis
     * 
     * @param anzahlTropfenImKreis
     *            Tropfen, die sich innerhalb des Kreissegments befinden
     * @return gibt eine genäherte Kreiszahl Pi zurück
     */
    // Wichtig hier: double-Cast
    public static BigDecimal berechnePI(long anzahlTropfenImKreis) {
        return new BigDecimal(((double) anzahlTropfenImKreis / PRECISION) * 4);
    }

}