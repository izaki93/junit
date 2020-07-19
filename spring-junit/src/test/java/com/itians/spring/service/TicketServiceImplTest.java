package com.itians.spring.service;

import com.itians.spring.dao.TicketDAO;
import com.itians.spring.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
class TicketServiceImplTest {

    @Mock
    TicketDAO ticketDAO;

    @Autowired
    @InjectMocks
    private TicketServiceImpl ticketService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void buyTicket() {
        //given
        when(ticketDAO.creatTicket(any(Ticket.class))).thenReturn(1);
        //when
        int result = ticketService.buyTicket("Ibrahim", "345678");
        //then
        assertEquals(result, 1);
    }
}