package com.itians.junit;


public class GreetingImpl implements Greeting {

    public String Greet(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return String.format("Hello : %s", name);
    }
}
