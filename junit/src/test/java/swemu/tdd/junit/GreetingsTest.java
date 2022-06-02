package swemu.tdd.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingsTest {
    @Test
    @DisplayName("sayHello() should return 'hello'")
    void sayHello() {
        var greetings = new Greetings();

        var hello = greetings.sayHello();

        assertEquals("Hello", hello);
    }
}
