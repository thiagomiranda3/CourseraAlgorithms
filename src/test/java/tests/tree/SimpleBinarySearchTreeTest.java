package tests.tree;

import br.com.tommiranda.algorithms.trees.SimpleBinarySearchTree;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class SimpleBinarySearchTreeTest extends BaseTest {

    @Test
    public void testaArvore() {
        SimpleBinarySearchTree<Integer, Integer> bst = new SimpleBinarySearchTree<>();
        bst.put(5, 5);
        bst.put(8, 8);
        bst.put(6, 6);
        bst.put(9, 9);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(1, 1);

        System.out.println("------------ Árvore ------------");
        bst.mostraArvore();
        System.out.println("--------------------------------");

        System.out.println("Valor: " + 4 + " - Ceiling: " + bst.ceiling(4) + " - Floor: " + bst.floor(4));
        System.out.println("Valor: " + 9 + " Rank: " + bst.rank(9));

        bst.printInorder();
    }
}
