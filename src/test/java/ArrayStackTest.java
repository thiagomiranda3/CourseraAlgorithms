import br.com.tommiranda.algorithms.ArrayStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {

    @Test
    public void testaPilha() {
        var stack = new ArrayStack<String>();

        stack.push("1");
        stack.push("2");

        stack.print();

        Assertions.assertEquals(stack.pop(), "2");

        stack.push("3");

        stack.print();

        Assertions.assertEquals(stack.pop(), "3");
        Assertions.assertEquals(stack.pop(), "1");
    }
}
