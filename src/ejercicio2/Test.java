package ejercicio2;

public class Test {

	public static void main(String[] args) {
		Baraja b = new Baraja();
		System.out.println(b.estaOrdenada());
		b.desordenar();
		b.mostrarCartas();
		System.out.println(b.estaOrdenada());
	}

}
