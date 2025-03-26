package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManagerTest {
    private DatabaseManager db;
    
    @Before
    public void setUp() {
        limparBanco();
        db = new DatabaseManager();
    }
    
    private void limparBanco() {
        try {
            // Fechar conexões existentes
            if (db != null && db.getConnection() != null) {
                db.getConnection().close();
            }
            
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
    public void testCadastrarUsuario() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        usuario.setId(1);
        assertTrue(db.cadastrarUsuario(usuario));
    }

    @Test
    public void testBuscarUsuario() {
        // Primeiro cadastrar um usuário
        Usuario novoUsuario = new Usuario("Teste", "teste@email.com", "senha123");
        assertTrue(db.cadastrarUsuario(novoUsuario));
        
        // Depois buscar o usuário cadastrado
        Usuario usuario = db.buscarUsuario("teste@email.com");
        assertNotNull(usuario);
        assertEquals("teste@email.com", usuario.getEmail());
    }

    @Test
    public void testCriarAgendamento() {
        // Primeiro cadastrar um usuário
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        assertTrue(db.cadastrarUsuario(usuario));
        
        // Depois criar um agendamento para este usuário
        Agendamento agendamento = new Agendamento(1, "20/03/2024", "14:00", "Reunião");
        assertTrue(db.criarAgendamento(agendamento));
    }

    @Test
    public void testListarAgendamentos() {
        // Primeiro cadastrar um usuário
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        assertTrue(db.cadastrarUsuario(usuario));
        
        // Criar alguns agendamentos
        Agendamento agendamento1 = new Agendamento(1, "20/03/2024", "14:00", "Reunião 1");
        Agendamento agendamento2 = new Agendamento(1, "21/03/2024", "15:00", "Reunião 2");
        assertTrue(db.criarAgendamento(agendamento1));
        assertTrue(db.criarAgendamento(agendamento2));
        
        // Listar os agendamentos
        ArrayList<Agendamento> agendamentos = db.listarAgendamentos(1);
        assertNotNull(agendamentos);
        assertEquals(2, agendamentos.size());
    }

    @Test
    public void testExcluirAgendamento() {
        // Primeiro cadastrar um usuário
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        assertTrue(db.cadastrarUsuario(usuario));
        
        // Criar um agendamento
        Agendamento agendamento = new Agendamento(1, "20/03/2024", "14:00", "Reunião");
        assertTrue(db.criarAgendamento(agendamento));
        
        // Buscar o agendamento criado
        ArrayList<Agendamento> agendamentos = db.listarAgendamentos(1);
        assertFalse(agendamentos.isEmpty());
        
        // Excluir o agendamento
        assertTrue(db.excluirAgendamento(agendamentos.get(0)));
        
        // Verificar se foi excluído
        agendamentos = db.listarAgendamentos(1);
        assertTrue(agendamentos.isEmpty());
    }
} 