package com.itians.mockito.scrapbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ATest {

    @Mock
    B b;

    private A a;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        a= new A(b);
    }

    //test void method implicitly need not to write when() method in given section
    @Test
    void usesVoidMethod_Should_Call_VoidMethod() throws Exception {
        //given
        doNothing().when(b).voidMethod();
        //when
        //then
        assertSame(1, a.usesVoidMethod());
        verify(b).voidMethod();
    }

    @Test
    void usesVoidMethod_Should_throw_RuntimeException() throws Exception {
        //given
        doThrow(Exception.class).when(b).voidMethod();
        //when
        //then
        assertThrows(RuntimeException.class,() -> a.usesVoidMethod());
        verify(b).voidMethod();
    }

    @Test
    void testConsecutiveCalls() throws Exception {
        //given
        //the following means when voidMethod() called for 1st time -> doNothing
        // and when called for 2nd time -> doThrow
        doNothing().doThrow(Exception.class).when(b).voidMethod();
        //when
        //then

        // doNothing for 1st call
        a.usesVoidMethod();

        //doThrow for 2nd call
        assertThrows(RuntimeException.class,() -> a.usesVoidMethod());
        verify(b,times(2)).voidMethod();
    }
}