package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    @BeforeAll
    public void printNomeTeste() {
        System.out.println("\n#### TESTE: " + this.getClass().getSimpleName());
    }
}
