package structures;

import br.com.tommiranda.algorithms.structures.LinkedStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedStackTest {

    @Test
    public void testaPilha() {
        var stack = new LinkedStack();

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
