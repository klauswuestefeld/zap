package danisgame;

import java.util.Random;
import java.util.Scanner;


public class SimplesMain {
	
	public static void main(String[] args) {
		while (true)
			tabuada();
	}

	private static void tabuada() {
		Random random = new Random();
		int numero1 = random.nextInt(13);
		int numero2 = random.nextInt(13);
		System.out.println("Quanto é " + numero1 + " x " + numero2 + "?");
		
		long tempoAntes = System.currentTimeMillis();
		String resposta = new Scanner(System.in).nextLine();
		long tempoDepois = System.currentTimeMillis();
		
		if (tempoDepois - tempoAntes > 5000)
			vermelho("Voce demorou mais que 5 segundos!!!");
		else
			if (resposta.equals("" + numero1 * numero2))
				System.out.println("Certo!");
			else
				vermelho("Errado! É " + numero1 * numero2);
		
	}

	private static void vermelho(String mensagem) {
		synchronized (System.out) {
			System.err.println(mensagem);
			pausa();
		}
	}

	private static void pausa() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}
	}

}