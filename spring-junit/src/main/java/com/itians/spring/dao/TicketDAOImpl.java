package com.itians.spring.dao;

import com.itians.spring.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDAOImpl implements TicketDAO {

    @Override
    public int creatTicket(Ticket ticket) {
        return 1;
    }
}
