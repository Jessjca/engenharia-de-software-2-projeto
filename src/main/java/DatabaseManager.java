

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:agenda.db";
    private static Connection conn = null;

    public static void inicializar() {
        try {
            // Carregar o driver do SQLite
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
            criarTabelas();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void criarTabelas() throws SQLException {
        String criarTabelaUsuarios = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                email TEXT UNIQUE NOT NULL,
                senha TEXT NOT NULL
            )
        """;

        String criarTabelaAgendamentos = """
            CREATE TABLE IF NOT EXISTS agendamentos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                usuario_id INTEGER NOT NULL,
                data TEXT NOT NULL,
                hora TEXT NOT NULL,
                descricao TEXT NOT NULL,
                FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
            )
        """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(criarTabelaUsuarios);
            stmt.execute(criarTabelaAgendamentos);
        }
    }

    public static void salvarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getSenha());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Usuario buscarUsuario(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void salvarAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (usuario_id, data, hora, descricao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, buscarIdUsuario(agendamento.getUsuario()));
            pstmt.setString(2, agendamento.getData());
            pstmt.setString(3, agendamento.getHora());
            pstmt.setString(4, agendamento.getDescricao());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Agendamento> buscarAgendamentos(Usuario usuario) {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamentos WHERE usuario_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, buscarIdUsuario(usuario));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                agendamentos.add(new Agendamento(
                    usuario,
                    rs.getString("data"),
                    rs.getString("hora"),
                    rs.getString("descricao")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendamentos;
    }

    public static void excluirAgendamento(Agendamento agendamento) {
        String sql = "DELETE FROM agendamentos WHERE usuario_id = ? AND data = ? AND hora = ? AND descricao = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, buscarIdUsuario(agendamento.getUsuario()));
            pstmt.setString(2, agendamento.getData());
            pstmt.setString(3, agendamento.getHora());
            pstmt.setString(4, agendamento.getDescricao());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int buscarIdUsuario(Usuario usuario) {
        String sql = "SELECT id FROM usuarios WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
} 