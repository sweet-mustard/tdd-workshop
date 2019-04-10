package swemu.tdd.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingsTest {
    @Test
    void sayHelloShouldSayHello() {
        var greetings = new Greetings();

        var hello = greetings.sayHello();

        assertEquals(hello, "Hello");
    }
}
