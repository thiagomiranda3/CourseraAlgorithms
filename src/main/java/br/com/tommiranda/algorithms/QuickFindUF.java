package br.com.tommiranda.algorithms;

/*
* Verifica se dois valores estão unidos ou não. Feito com um array:
* No início o índice tem o mesmo valor do array (0: [0], 1: [1], 2: [2]...)
* Mas caso haja uma união entre o 0 e 1, o íncide 1 fica com o valor de 0. (0: [0], 1: [0], 2: [2]...)
* Para verificar se dois valores estão conectados, basta verificar se possui o mesmo pai.
*/
public class QuickFindUF {

    private int[] id;

    // Inicio o array com os valores.
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    // Busca a raiz onde o índice e o valor são os mesmos
    public int root(int i) {
        while(i != id[i])
            i = id[i];

        return i;
    }

    // Se possuem o mesmo pai, entao estão conectados
    public boolean connected(int P, int Q) {
        return root(P) == root(Q);
    }

    // Raiz de Q passa a ser o pai da raiz de P
    public void union(int P, int Q) {
        int proot = root(P);
        int qroot = root(Q);

        id[proot] = qroot;
    }
}
