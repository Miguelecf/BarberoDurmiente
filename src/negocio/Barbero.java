package negocio;


//Creamos al hilo de barbero que es donde se ejecutara
//Gran parte del programa al invocarlo con el run();

public class Barbero extends Thread {
	private Barberia barberia;

	/**
	 * Indica si el barbero está dormido o no
	 */
	public boolean dormido;
	private int contador = 0;

	public Barbero(Barberia barberia) {
		this.barberia = barberia;
	}

	public boolean isDormido() {
		return dormido;
	}

	public void setDormido(boolean dormido) {
		this.dormido = dormido;
	}

	//El while(true) indica que el programa sigue hasta que lo frenemos. Van a ir llegando clientes a medida que el programa corra mas.
	//Y siempre se van a ir sumando mas segundos en el contador segundos. 
	public void run() {
	
		while (true) {

			if (isDormido() == false) {
				if (barberia.getSillaDeBarberia().isOcupada() == true) {

					// Si no hay nadie esperando, atiendo y duermo
					if (barberia.sillasDeEsperaVacias() == true) {
						barberia.getSillaDeBarberia().setOcupada(false);
						setDormido(true);

						// De lo contrario, atiendo al siguiente en la silla de espera
					} else {
						barberia.desocuparSillaEspera();
					}

					// Atiendo si hay alguien en la silla de barbería
					System.out.println("Atendí al cliente " + contador);
					contador++;

				}
			}
			try {

				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}