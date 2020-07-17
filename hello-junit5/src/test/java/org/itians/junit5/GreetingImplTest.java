package org.itians.junit5;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Uncomment the next line when you are in Eclipse IDEA
//@ExtendWith(JunitPlatform.class)
public class GreetingImplTest {

    private Greeting greeting;

    @BeforeEach
    public void setUp() {
        System.out.println("Setup");
        //given
        greeting = new GreetingImpl();
    }

    @Test
    public void greet() {
        System.out.println("greet");
        //given
        //when
        String result = greeting.Greet("Junit");
        //then
        assertNotNull(result);
        assertEquals("Hello : Junit", result);
    }

    @Test
    public void greetShouldThrowAnException_For_NameIsNull() {
        System.out.println("greetShouldThrowAnException_For_NameIsNull");
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            greeting.Greet(null);
        });
    }

    @Test
    public void greetShouldThrowAnException_For_NameIsBlank() {
        System.out.println("greetShouldThrowAnException_For_NameIsBlank");
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            greeting.Greet("");
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown");
        greeting = null;
    }
}