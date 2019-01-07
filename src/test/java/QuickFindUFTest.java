import br.com.tommiranda.algorithms.QuickFindUF;
import org.junit.jupiter.api.Test;

public class QuickFindUFTest {

    @Test
    public void testaUniao() {
        QuickFindUF qf = new QuickFindUF(10);

        qf.union(0, 1);
        qf.union(5, 3);
        qf.union(3, 4);

        
    }
}
