package VAR_SL;

import java.math.*;
import java.rmi.RemoteException;

public class PI implements RMI {

	public BigDecimal berechnePI() throws RemoteException {
		// member ist nur eine Hilfsvariable, ergebnis für randomX^2+ randomY^2

		double member = 0.0;
		double hypothenuse = 0.0;
		double anzahlInnen = 0.0;
		double anzahlDraussen = 0.0;

		for (int i = 1; i <= 5000; i++) {

			// RandomX, ist eine Zufallszahl für X
			// RandomY, ist eine Zufallszahl für Y

			double randomX = (double) Math.random();
			double randomY = (double) Math.random();
			member = (randomX * randomX) + (randomY * randomY); // Phytagoras,für die Hypothenuse
			hypothenuse = Math.sqrt(member);
			if (hypothenuse < 1) {
				anzahlInnen += 1;
			} else
				anzahlDraussen += 1;

		}

		double a = (anzahlInnen / (anzahlDraussen + anzahlInnen)) * 4;

		BigDecimal retValue = new BigDecimal(a);

		return retValue;
	}

	public static void main(String[] args) throws RemoteException {
		PI p = new PI();
		System.out.println(p.berechnePI());
		
	}

}
