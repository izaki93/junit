package com.itians.mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class ListTest {

    @Spy
    List<String> myList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void name() {
        //given
        // here in spy we call the real method
        myList.add("Ibrahim");
        myList.add("Ahmed");

        //when

        //if we comment lines 29 ,30 it will throw exception as myList spy is calling the real method
        //when(myList.get(0)).thenReturn("Mario");

        //we can call the real method with Mockito object
         when(myList.size()).thenCallRealMethod();

        // we must use the following syntax with spy
        doReturn(3).when(myList).size();

        //then
        assertSame(3,myList.size());
    }
}
