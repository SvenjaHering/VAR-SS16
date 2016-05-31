package VAR_SL;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Server extends UnicastRemoteObject implements RMI {

    protected Server() throws RemoteException {
        super();
    }

    /**
     * Mehtode, die vom Client gerufen wird um eine Anzahl von Zufallszahlen zu erzeugen und die Anzahl der im Kreissegment befindlicher Tropfen zurückgibt
     * 
     * @param precision
     *            Anzahl der Zufallszahlen
     * @return Gibt die Anzahl der Tropfen im Kreissegment zurück
     */
    @Override
    public long berechneTropfenImKreis(long precision) {
        long member = 0; // member als Hilfsvariable, ergebnis für randomX^2+ randomY^2
        long hypothenuse = 0;
        long anzahlInnerhalb = 0;

        for (int i = 1; i <= precision; i++) {
            long randomX = (long) Math.random(); // RandomX, ist eine Zufallszahl für X
            long randomY = (long) Math.random(); // RandomY, ist eine Zufallszahl für Y
            member = (randomX * randomX) + (randomY * randomY); // Phytagoras,für die Hypothenuse
            hypothenuse = (long) Math.sqrt(member);
            if (hypothenuse < 1) {
                anzahlInnerhalb++;
            }
        }
        return anzahlInnerhalb;
    }

}
