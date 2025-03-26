package model;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:agenda.db";
    private Connection conn;

    public DatabaseManager() {
        try {
            Class.forName("org.sqlite.JDBC");
            inicializarBanco();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite não encontrado: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void inicializarBanco() {
        try {
            conn = DriverManager.getConnection(DB_URL);
            criarTabelas();
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar banco de dados: " + e.getMessage());
        }
    }

    private void criarTabelas() {
        String criarTabelaUsuarios = 
            "CREATE TABLE IF NOT EXISTS usuarios (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    nome TEXT NOT NULL," +
            "    email TEXT UNIQUE NOT NULL," +
            "    senha TEXT NOT NULL" +
            ")";

        String criarTabelaAgendamentos = 
            "CREATE TABLE IF NOT EXISTS agendamentos (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    usuario_id INTEGER NOT NULL," +
            "    data TEXT NOT NULL," +
            "    hora TEXT NOT NULL," +
            "    descricao TEXT NOT NULL," +
            "    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)" +
            ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(criarTabelaUsuarios);
            stmt.execute(criarTabelaAgendamentos);
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getSenha());
            pstmt.executeUpdate();
            
            // Obter o ID gerado
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                usuario.setId(rs.getInt(1));
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Usuario buscarUsuario(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
                usuario.setId(rs.getInt("id"));
                return usuario;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Agendamento> listarAgendamentos(int usuarioId) {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamentos WHERE usuario_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Agendamento agendamento = new Agendamento(
                    rs.getInt("usuario_id"),
                    rs.getString("data"),
                    rs.getString("hora"),
                    rs.getString("descricao")
                );
                agendamento.setId(rs.getInt("id"));
                agendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar agendamentos: " + e.getMessage());
        }
        return agendamentos;
    }

    public boolean criarAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (usuario_id, data, hora, descricao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, agendamento.getUsuarioId());
            pstmt.setString(2, agendamento.getData());
            pstmt.setString(3, agendamento.getHora());
            pstmt.setString(4, agendamento.getDescricao());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean excluirAgendamento(Agendamento agendamento) {
        String sql = "DELETE FROM agendamentos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, agendamento.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
} 