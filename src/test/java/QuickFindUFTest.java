import br.com.tommiranda.algorithms.QuickFindUF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickFindUFTest {

    @Test
    public void testaUniao() {
        QuickFindUF qf = new QuickFindUF(10);

        qf.union(0, 1);
        qf.union(5, 3);
        qf.union(2, 6);
        qf.union(6, 7);
        qf.union(3, 4);
        qf.union(4, 6);

        Assertions.assertEquals(qf.connected(0, 1), true);
        Assertions.assertEquals(qf.connected(5, 3), true);

        // Tem que estar conectado indiretamente
        Assertions.assertEquals(qf.connected(6, 5), true);

        // Nenhuma conexão direta ou indireta
        Assertions.assertEquals(qf.connected(0, 9), false);
    }
}
