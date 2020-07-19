package com.itians.order.bo;

import com.itians.order.bo.exception.BOException;
import com.itians.order.model.Order;

public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int id) throws BOException;

    boolean deleteOrder(int id) throws BOException;
}
