package controller;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Usuario;
import model.Agendamento;
import java.util.ArrayList;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainControllerTest {
    private MainController controller;
    private String dataFutura;
    
    @Before
    public void setUp() {
        limparBanco();
        controller = new MainController();
        
        // Gerar uma data futura (amanhã)
        LocalDate amanha = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataFutura = amanha.format(formatter);
    }
    
    private void limparBanco() {
        try {
            // Criar uma nova conexão e dropar as tabelas
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.db");
            Statement stmt = conn.createStatement();
            
            // Dropar as tabelas se existirem
            stmt.execute("DROP TABLE IF EXISTS agendamentos");
            stmt.execute("DROP TABLE IF EXISTS usuarios");
            
            // Criar as tabelas novamente
            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, email TEXT UNIQUE NOT NULL, senha TEXT NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS agendamentos (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario_id INTEGER NOT NULL, data TEXT NOT NULL, hora TEXT NOT NULL, descricao TEXT NOT NULL, FOREIGN KEY (usuario_id) REFERENCES usuarios(id))");
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testLogin() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        controller.cadastrarUsuario(usuario);
        assertTrue(controller.fazerLogin("teste@email.com", "senha123"));
    }

    @Test
    public void testCadastrarUsuario() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        assertTrue(controller.cadastrarUsuario(usuario));
    }

    @Test
    public void testCriarAgendamento() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        controller.cadastrarUsuario(usuario);
        controller.fazerLogin("teste@email.com", "senha123");
        assertTrue(controller.criarAgendamento(dataFutura, "14:00", "Reunião"));
    }

    @Test
    public void testExcluirAgendamento() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        controller.cadastrarUsuario(usuario);
        controller.fazerLogin("teste@email.com", "senha123");
        
        // Criar um agendamento
        controller.criarAgendamento(dataFutura, "14:00", "Reunião");
        
        // Buscar o agendamento criado
        ArrayList<Agendamento> agendamentos = controller.listarAgendamentos(usuario.getId());
        assertFalse(agendamentos.isEmpty());
        
        // Excluir o agendamento
        assertTrue(controller.excluirAgendamento(agendamentos.get(0)));
        
        // Verificar se foi excluído
        agendamentos = controller.listarAgendamentos(usuario.getId());
        assertTrue(agendamentos.isEmpty());
    }

    @Test
    public void testListarAgendamentos() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        controller.cadastrarUsuario(usuario);
        controller.fazerLogin("teste@email.com", "senha123");
        controller.criarAgendamento(dataFutura, "14:00", "Reunião");
        ArrayList<Agendamento> agendamentos = controller.listarAgendamentos(usuario.getId());
        assertNotNull(agendamentos);
        assertFalse(agendamentos.isEmpty());
    }
} 