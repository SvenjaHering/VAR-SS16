package VAR_SL;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Server extends UnicastRemoteObject implements RMI {

    protected Server() throws RemoteException {
        super();
    }

    // TODO Methode in main integrieren

    /**
     * Mehtode, die vom Client gerufen wird um eine Anzahl von Zufallszahlen zu erzeugen und die Anzahl der im Kreissegment befindlicher Tropfen zurückgibt
     * 
     * @param precision Anzahl der Zufallszahlen
     * @return Gibt die Anzahl der Tropfen im Kreissegment zurück
     */
    public double berechneZufallszahlen(int precision) {
        double member = 0.0; // member als Hilfsvariable, ergebnis für randomX^2+ randomY^2
        double hypothenuse = 0.0;
        double anzahlInnerhalb = 0.0;
        double anzahlAusserhalb = 0.0;

        for (int i = 1; i <= precision; i++) {
            double randomX = Math.random(); // RandomX, ist eine Zufallszahl für X
            double randomY = Math.random(); // RandomY, ist eine Zufallszahl für Y
            member = (randomX * randomX) + (randomY * randomY); // Phytagoras,für die Hypothenuse
            hypothenuse = Math.sqrt(member);
            if (hypothenuse < 1) {
                anzahlInnerhalb += 1;
            } else
                anzahlAusserhalb += 1;
        }
        return anzahlInnerhalb;
    }

    @Override
    public BigDecimal berechnePI(int precision) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

}
