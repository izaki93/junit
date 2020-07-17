package com.itians.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingImplTest {

    private Greeting greeting;
    @Before
    public void setUp() throws Exception {
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

    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowAnException_For_NameIsNull() {
        System.out.println("greetShouldThrowAnException_For_NameIsNull");
        //given
        //when
        greeting.Greet(null);
        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowAnException_For_NameIsBlank() {
        System.out.println("greetShouldThrowAnException_For_NameIsBlank");
        //given
        //when
        greeting.Greet("");
        //then
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
        greeting =null;
    }
}