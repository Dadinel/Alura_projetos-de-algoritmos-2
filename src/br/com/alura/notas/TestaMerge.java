package br.com.alura.notas;

public class TestaMerge {
    public static void main(String[] args) {
        Nota[] notasDoMauricio = {
            new Nota("André", 4),
            new Nota("Mariana", 5),
            new Nota("Carlos", 8.5),
            new Nota("Paulo", 9)
        };

        Nota[] notasDoAlberto = {
            new Nota("Jonas", 3),
            new Nota("Juliana", 6.7),
            new Nota("Guilherme", 8),
            new Nota("Lúcia", 9.3),
            new Nota("Ana", 10)
        };

        Nota[] rank = junta(notasDoMauricio, notasDoAlberto);

        for(Nota nota : rank) {
            System.out.println(nota.getAluno() + " " + nota.getValor());
        }
    }

    private static Nota[] junta(Nota[] notasDoMauricio, Nota[] notasDoAlberto) {
        int total = notasDoMauricio.length + notasDoAlberto.length;

        Nota[] resultado = new Nota[total];

        int atualDoMauricio = 0;
        int atualDoAlberto = 0;
        int atual = 0;

        while(atualDoMauricio < notasDoMauricio.length && atualDoAlberto < notasDoAlberto.length ) {
            Nota nota1 = notasDoMauricio[atualDoMauricio];
            Nota nota2 = notasDoAlberto[atualDoAlberto];
            System.out.println("Estou comparando " +nota1.getAluno() + " com " + nota2.getAluno());

            if(nota1.getValor() < nota2.getValor()) {
                resultado[atual] = nota1;
                atualDoMauricio++;
            }
            else {
                resultado[atual] = nota2;
                atualDoAlberto++;
            }

            atual++;
        }

        System.out.println("Estou saindo");
        return resultado;
    }
}