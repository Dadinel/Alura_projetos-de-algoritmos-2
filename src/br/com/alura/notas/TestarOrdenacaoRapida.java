package br.com.alura.notas;

public class TestarOrdenacaoRapida {
	public static void main(String[] args) {
		Nota guilherme = new Nota("Guilherme", 8);

        Nota[] notas = {
                new Nota("André", 4),
                new Nota("Carlos", 8.5),
                new Nota("Ana", 10),
                new Nota("Jonas", 3),
                new Nota("Juliana", 6.7),
                new Nota("Lúcia", 9.3),
                new Nota("Paulo", 9),
                new Nota("Mariana", 5),
                guilherme
            };        

        ordena(notas, 0, notas.length);

        int encontrei = busca(notas, 0, notas.length, 8.3);

        if(encontrei >= 0) {
        	System.out.println("Encontrei a nota em " + encontrei + ".");
        }
        else {
        	System.out.println("Não encontrei a nota");
        }

        for(int atual = 0; atual < notas.length; atual++) {
        	Nota nota = notas[atual];
        	System.out.println(nota.getAluno() + " " + nota.getValor());
        }
	}

	private static int busca(Nota[] notas, int de, int ate, double buscando) {
		if(de > ate) {
			return -1;
		}

		int meio = (de + ate) / 2;

		Nota nota = notas[meio];

		if(buscando == nota.getValor()) {
			return meio;
		}
		else if(buscando < nota.getValor() ) {
			return busca(notas, de, meio - 1, buscando);
		}
		
		return busca(notas, meio + 1, ate, buscando); 
	}

	private static void ordena(Nota[] notas, int de, int ate) {
		int elements = ate - de;

		if(elements > 1) {
			int posicaoDoPivo = particiona(notas, de, ate);
			ordena(notas, de, posicaoDoPivo);
			ordena(notas, posicaoDoPivo+1, ate);
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
