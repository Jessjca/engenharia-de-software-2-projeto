import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;

public class DatabaseManagerTest {
    private DatabaseManager db;
    
    @Before
    public void setUp() {
        db = new DatabaseManager();
        db.inicializarBanco();
        limparBanco();
    }
    
    @After
    public void tearDown() {
        limparBanco();
    }
    
    private void limparBanco() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.db");
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM agendamentos");
            stmt.execute("DELETE FROM usuarios");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCadastrarUsuario() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        assertTrue(db.cadastrarUsuario(usuario));
    }
    
    @Test
    public void testCadastrarUsuarioDuplicado() {
        Usuario usuario1 = new Usuario("Teste1", "teste@email.com", "senha123");
        Usuario usuario2 = new Usuario("Teste2", "teste@email.com", "senha456");
        db.cadastrarUsuario(usuario1);
        assertFalse(db.cadastrarUsuario(usuario2));
    }
    
    @Test
    public void testCriarAgendamento() {
        Agendamento agendamento = new Agendamento(1, "2024-03-20", "14:00", "Reunião");
        assertTrue(db.criarAgendamento(agendamento));
    }
    
    @Test
    public void testListarAgendamentos() {
        Agendamento agendamento = new Agendamento(1, "2024-03-20", "14:00", "Reunião");
        db.criarAgendamento(agendamento);
        assertNotNull(db.listarAgendamentos(1));
        assertTrue(db.listarAgendamentos(1).size() > 0);
    }
} 