package tests.tree;

import br.com.tommiranda.algorithms.trees.SimpleBinarySearchTree;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class SimpleBinarySearchTreeTest extends BaseTest {

    @Test
    public void testaArvore() {
        SimpleBinarySearchTree<Integer, Integer> bst = new SimpleBinarySearchTree<>();
        bst.put(5, 5);
        bst.put(3, 3);
        bst.put(8, 8);
        bst.put(2, 2);
        bst.put(1, 1);
        bst.put(9, 9);

        System.out.println("------------ Árvore ------------");
        bst.mostraArvore();
        System.out.println("--------------------------------");

        System.out.println("Ceiling: " + bst.ceiling(4) + " - Floor: " + bst.floor(4));
    }
}
