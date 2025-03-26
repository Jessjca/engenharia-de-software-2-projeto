import org.junit.Test;
import static org.junit.Assert.*;

public class AgendamentoTest {
    
    @Test
    public void testCriarAgendamento() {
        Agendamento agendamento = new Agendamento(1, "2024-03-20", "14:00", "Reunião");
        assertEquals(1, agendamento.getUsuarioId());
        assertEquals("2024-03-20", agendamento.getData());
        assertEquals("14:00", agendamento.getHora());
        assertEquals("Reunião", agendamento.getDescricao());
    }
    
    @Test
    public void testValidarData() {
        Agendamento agendamento = new Agendamento(1, "2024-03-20", "14:00", "Reunião");
        assertTrue(agendamento.validarData("2024-03-20"));
        assertFalse(agendamento.validarData("2023-01-01")); // Data passada
    }
    
    @Test
    public void testValidarHora() {
        Agendamento agendamento = new Agendamento(1, "2024-03-20", "14:00", "Reunião");
        assertTrue(agendamento.validarHora("14:00"));
        assertFalse(agendamento.validarHora("25:00")); // Hora inválida
    }
} 