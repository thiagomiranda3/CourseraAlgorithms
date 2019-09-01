package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    @BeforeAll
    public void printNomeTeste() {
        System.out.println("\n#### TESTE: " + this.getClass().getSimpleName());
    }

    public void printTempos(long nanoTime) {
        long miliTime = nanoTime / 1_000_000;
        long secTime = miliTime / 1000;

        if (nanoTime < 1_000_000) {
            System.out.println("\nTempo: " + nanoTime + " ns");
        } else {
            System.out.println("Tempo: " + miliTime + " ms");
        }
    }
}
