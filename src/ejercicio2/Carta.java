package ejercicio2;

import java.util.Objects;

public class Carta {
	private static final int MIN_CARTA = 1;
	private static final int MAX_CARTA = 12;
	private int numero;
	private Palo palo;
	
	public Carta(int numero, Palo palo) {
		setNumero(numero);
		setPalo(palo);
	}
	
	public void setNumero(int numero) {
		if (numero < MIN_CARTA || numero > MAX_CARTA) {
			throw new RuntimeException("El número de una carta debe estar entre " + MIN_CARTA + " y " + MAX_CARTA);
		}
		this.numero = numero;
	}
	
	public void setPalo(Palo p) {
		if (p == null) {
			throw new RuntimeException("El palo no puede ser null");
		}
		this.palo = p;
	}
	

	// Autogenerado con Eclipse...
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return numero == other.numero && palo == other.palo;
	}
	
	public boolean sos(int numero, Palo p) {
		return this.numero == numero && this.palo == p;
	}

	@Override
	public String toString() {
		return numero + " de " + palo;
	}
	
	
}
