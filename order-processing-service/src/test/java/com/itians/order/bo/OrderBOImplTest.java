package com.itians.order.bo;

import com.itians.order.bo.exception.BOException;
import com.itians.order.dao.OrderDAO;
import com.itians.order.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

class OrderBOImplTest {
    OrderBOImpl orderBOImpl;

    @Mock
    OrderDAO orderDAOMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        orderBOImpl = new OrderBOImpl(orderDAOMock);
    }

    @Test
    void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
        //given
        // Stub out the method call for orderDAO dependency and setup the expectation.
        // any(Order.class)  => means creating dummy Order on the fly (test double pattern her are dummy)
        when(orderDAOMock.create(any(Order.class))).thenReturn(new Integer(1));

        //when
        boolean result = orderBOImpl.placeOrder(any(Order.class));

        //then
        assertTrue(result);
        verify(orderDAOMock).create(any(Order.class));
        verify(orderDAOMock, times(1)).create(any(Order.class));
    }

    @Test
    void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {
        //given
        // Stub out the method call for orderDAO dependency and setup the expectation.
        when(orderDAOMock.create(any(Order.class))).thenReturn(new Integer(0));

        //when
        boolean result = orderBOImpl.placeOrder(any(Order.class));

        //then
        assertFalse(result);
        verify(orderDAOMock).create(any(Order.class));
    }

    @Test
    void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
        //given
        // Stub out the method call for orderDAO dependency and setup the expectation.
        when(orderDAOMock.create(any(Order.class))).thenThrow(SQLException.class);

        //when
        //then
        assertThrows(BOException.class, () -> orderBOImpl.placeOrder(any(Order.class)));
    }

    @Test
    void cancelOrder_Should_Cancel_Order() throws SQLException, BOException {
        //given
        Order order = new Order();
        when(orderDAOMock.read(new Integer(anyInt()))).thenReturn(order);
        when(orderDAOMock.update(order)).thenReturn(1);

        //when
        boolean result = orderBOImpl.cancelOrder(new Integer(anyInt()));

        //then
        assertTrue(result);
        verify(orderDAOMock).read(new Integer(anyInt()));
        verify(orderDAOMock).update(any(Order.class));
    }

    @Test
    void cancelOrder_Should_Not_Cancel_Order() throws SQLException, BOException {
        //given
        Order order = new Order();
        when(orderDAOMock.read(new Integer(anyInt()))).thenReturn(order);
        when(orderDAOMock.update(order)).thenReturn(0);

        //when
        boolean result = orderBOImpl.cancelOrder(new Integer(anyInt()));

        //then
        assertFalse(result);
        verify(orderDAOMock).read(new Integer(anyInt()));
        verify(orderDAOMock).update(any(Order.class));
    }

    @Test
    void cancelOrder_Should_Throw_BOExceptionOnRead() throws SQLException, BOException {
        //given
        when(orderDAOMock.read(new Integer(anyInt()))).thenThrow(SQLException.class);

        //when
        //then
        assertThrows(BOException.class, () -> orderBOImpl.cancelOrder(new Integer(anyInt())));
    }

    @Test
    void cancelOrder_Should_Throw_BOExceptionOnUpdate() throws SQLException, BOException {
        //given
        Order order = new Order();
        when(orderDAOMock.read(new Integer(anyInt()))).thenReturn(order);
        when(orderDAOMock.update(order)).thenThrow(SQLException.class);

        //when
        //then
        assertThrows(BOException.class, () -> orderBOImpl.cancelOrder(new Integer(anyInt())));
    }


    @Test
    void deleteOrder_Should_Delete_Order() throws SQLException, BOException {
        //given
        when(orderDAOMock.delete(anyInt())).thenReturn(1);

        //when
        boolean result = orderBOImpl.deleteOrder(anyInt());

        //then
        assertTrue(result);
        verify(orderDAOMock).delete(new Integer(anyInt()));
    }

    @Test
    void deleteOrder_Should_Not_Delete_Order() throws SQLException, BOException {
        //given
        when(orderDAOMock.delete(anyInt())).thenReturn(0);

        //when
        boolean result = orderBOImpl.deleteOrder(anyInt());

        //then
        assertFalse(result);
        verify(orderDAOMock).delete(new Integer(anyInt()));
    }

    @Test
    void deleteOrder_Should_Throw_BOException() throws SQLException, BOException {
        //given
        when(orderDAOMock.delete(anyInt())).thenThrow(SQLException.class);

        //when
        //then
        assertThrows(BOException.class, () -> orderBOImpl.deleteOrder(anyInt()));
    }
}