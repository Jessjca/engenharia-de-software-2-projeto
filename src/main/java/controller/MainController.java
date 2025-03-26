package controller;

import model.Usuario;
import model.Agendamento;
import model.DatabaseManager;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainController {
    private DatabaseManager db;
    private Usuario usuarioLogado;

    public MainController() {
        db = new DatabaseManager();
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        return db.cadastrarUsuario(usuario);
    }

    public Usuario buscarUsuario(String email) {
        return db.buscarUsuario(email);
    }

    public boolean fazerLogin(String email, String senha) {
        Usuario usuario = buscarUsuario(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            usuarioLogado = usuario;
            return true;
        }
        return false;
    }

    public boolean criarAgendamento(String data, String hora, String descricao) {
        if (usuarioLogado == null) {
            return false;
        }

        // Validar data
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataAgendamento = LocalDate.parse(data, formatter);
            LocalDate hoje = LocalDate.now();
            
            if (dataAgendamento.isBefore(hoje)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        Agendamento agendamento = new Agendamento(usuarioLogado.getId(), data, hora, descricao);
        return db.criarAgendamento(agendamento);
    }

    public ArrayList<Agendamento> listarAgendamentos(int usuarioId) {
        return db.listarAgendamentos(usuarioId);
    }

    public boolean excluirAgendamento(Agendamento agendamento) {
        return db.excluirAgendamento(agendamento);
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
} 