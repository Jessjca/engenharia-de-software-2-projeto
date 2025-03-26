package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class AgendamentoTest {
    
    @Test
    public void testCriarAgendamento() {
        Agendamento agendamento = new Agendamento(1, "20/03/2024", "14:00", "Reunião");
        
        assertEquals(1, agendamento.getUsuarioId());
        assertEquals("20/03/2024", agendamento.getData());
        assertEquals("14:00", agendamento.getHora());
        assertEquals("Reunião", agendamento.getDescricao());
    }

    @Test
    public void testSetId() {
        Agendamento agendamento = new Agendamento(1, "20/03/2024", "14:00", "Reunião");
        agendamento.setId(1);
        assertEquals(1, agendamento.getId());
    }
} 