package com.itians.spring.service;

import com.itians.spring.dao.TicketDAO;
import com.itians.spring.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDAO ticketDAO;

    @Override
    public int buyTicket(String passengerName, String phone) {
        Ticket ticket = new Ticket();
        ticket.setPassengerName(passengerName);
        ticket.setPhone(phone);
        return ticketDAO.creatTicket(ticket);
    }
}
