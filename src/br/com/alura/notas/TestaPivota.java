package br.com.alura.notas;

public class TestaPivota {
	public static void main(String[] args) {
		Nota guilherme = new Nota("Guilherme", 8);

        Nota[] notas = {
                new Nota("Andr�", 4),
                new Nota("Carlos", 8.5),
                new Nota("Ana", 10),
                new Nota("Jonas", 3),
                new Nota("Juliana", 6.7),
                new Nota("L�cia", 9.3),
                new Nota("Paulo", 9),
                new Nota("Mariana", 5),
                guilherme
            };
        
        int novaPosicao = particiona(notas, 0, notas.length);

        System.out.println("O pivo foi para em " + novaPosicao);

        for(int atual = 0; atual < notas.length; atual++) {
        	Nota nota = notas[atual];
        	System.out.println(nota.getAluno() + " " + nota.getValor());
        }
	}

	private static int particiona(Nota[] notas, int inicial, int termino) {
		int menoresEncontrados = 0;
		Nota pivo = notas[termino - 1];

		for(int analisando = 0; analisando < termino -1; analisando++) {
			Nota atual = notas[analisando];

			if(atual.getValor() <= pivo.getValor()) {
				troca(notas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}

		troca(notas, termino -1, menoresEncontrados);

		return menoresEncontrados;
	}

	private static void troca( Nota[] notas, int de, int para) {
		Nota nota1 = notas[de];
		Nota nota2 = notas[para];
		notas[para] = nota1;
		notas[de] = nota2;
	}
}