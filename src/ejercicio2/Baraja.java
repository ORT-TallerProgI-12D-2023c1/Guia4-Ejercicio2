package ejercicio2;

import java.util.Random;

public class Baraja {
	private static final int CARTAS_POR_PALO = 12;
	private static final int CANT_PALOS = Palo.values().length;
	private Carta[] cartas;

	public Baraja() {
		this.cartas = new Carta[CARTAS_POR_PALO * CANT_PALOS];
		autoGenerarCartas();
	}
	
	// Forma 1
	/*
	 * private void autoGenerarCartas() { int idxActual = 0; for (int p = 0; p <
	 * CANT_PALOS; p++) { for (int n = 1; n <= CARTAS_POR_PALO; n++) {
	 * this.cartas[idxActual] = new Carta(n, Palo.values()[p]); idxActual++; } } }
	 */
	
	// Forma 2
	private void autoGenerarCartas() {
		for (int p = 0; p < CANT_PALOS; p++) {
			for (int n = 1; n <= CARTAS_POR_PALO; n++) {
				int offset = p * 12;
				int posRelativaCarta = n-1;
				int resultado = offset + posRelativaCarta;
				//System.out.println(resultado);
				this.cartas[resultado] = new Carta(n, Palo.values()[p]);
			}			
		}
	}
	
	public boolean estaOrdenada() {
		int p = 0;
		boolean estanOrdenadas = true;
		while (p < CANT_PALOS && estanOrdenadas) {
			int n = 1;
			while (n <= CARTAS_POR_PALO && estanOrdenadas) {
				int offset = p * 12;
				int posRelativaCarta = n-1;
				int resultado = offset + posRelativaCarta;
				estanOrdenadas = this.cartas[resultado].equals(new Carta(n, Palo.values()[p]));
				n++;
			}	
			p++;
		}
		return estanOrdenadas;
	}
	
	public void desordenar() {		
		for (int i = 0; i < 500; i++) {
			int rnd1 = generarNumeroAleatorio(0, CARTAS_POR_PALO * CANT_PALOS - 1);
			int rnd2 = generarNumeroAleatorio(0, CARTAS_POR_PALO * CANT_PALOS - 1);
			Carta aux = this.cartas[rnd1];
			this.cartas[rnd1] = this.cartas[rnd2];
			this.cartas[rnd2] = aux;
		}		
	}
	
	public static int generarNumeroAleatorio(int min, int max) {
	     Random random = new Random();
	     return random.nextInt(max - min + 1) + min;
	}
	
	public void mostrarCartas() {
		for (int i = 0; i < cartas.length; i++) {
			System.out.println(cartas[i]);				
		}
	}
	
}
