package br.com.alura.notas;

public class TestaEncontraMenores {
	public static void main(String[] args) {
		Nota guilherme = new Nota("Guilherme", 8);

        Nota[] notas = {
                new Nota("André", 4),
                new Nota("Carlos", 8.5),
                new Nota("Ana", 10),
                new Nota("Jonas", 3),
                new Nota("Juliana", 6.7),
                guilherme,
                new Nota("Paulo", 9),
                new Nota("Mariana", 5),
                new Nota("Lúcia", 9.3),
            };

        int menores = encontraMenores(guilherme, notas);

        System.out.println( "Número de menores: " + menores);
	}

	static int encontraMenores(Nota busca, Nota[] notas) {
		int menores = 0;

		for(int atual = 0; atual < notas.length; atual++) {
			Nota nota = notas[atual];

			if(nota.getValor() < busca.getValor()) {
				menores++;
			}
		}

		return menores;
	}
}
