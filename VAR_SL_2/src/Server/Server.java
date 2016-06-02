package Server;

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

        double pythagorasC;
        double hypothenuse;
        long anzahlInnerhalb = 0;

        for (int i = 1; i <= precision; i++) {
            double randomX = Math.random();
            double randomY = Math.random();

            // Prüfen, ob Tropfen innerhalb des Kreissegments
            pythagorasC = (randomX * randomX) + (randomY * randomY);
            hypothenuse = Math.sqrt(pythagorasC);
            if (hypothenuse <= 1) {
                anzahlInnerhalb++;
            }
        }
        return anzahlInnerhalb;
    }

}
