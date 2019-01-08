package br.com.tommiranda.algorithms;

/*
 * Verifica se dois valores estão unidos ou não. Feito com um array:
 * No início o índice tem o mesmo valor do array (0: [0], 1: [1], 2: [2]...)
 * Mas caso haja uma união entre o 0 e 1, o íncide 1 fica com o valor de 0. (0: [0], 1: [0], 2: [2]...)
 * Para verificar se dois valores estão conectados, basta verificar se possui o mesmo pai.
 */
public class QuickFindUF {

    // Array com os valores de união
    private int[] id;
    // Array com o tamanho entre a raiz e a folha
    private int[] sz;


    // Inicio o array com os valores.
    public QuickFindUF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // Busca a raiz onde o índice e o valor são os mesmos
    public int root(int i) {
        while (i != id[i])
            i = id[i];

        return i;
    }

    // Se possuem o mesmo pai, entao estão conectados
    public boolean connected(int P, int Q) {
        return root(P) == root(Q);
    }

    // Coloca a árvore de menor tamanho como filha da maior
    public void union(int P, int Q) {
        int proot = root(P);
        int qroot = root(Q);

        if (proot == qroot)
            return;

        // Se Raiz de P é menor que Raiz de Q, faz árvore P filha da árvore Q
        if(sz[proot] < sz[qroot]) {
            id[proot] = qroot;
            sz[qroot] += sz[proot];
        } else {
            id[qroot] = proot;
            sz[proot] += sz[qroot];
        }
    }

    public void printArray() {
        System.out.print("  ");
        for (int i = 0; i < id.length; i++) {
            System.out.print(i + " ");
        }

        System.out.print("\n[ ");
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.print("]");
    }
}
