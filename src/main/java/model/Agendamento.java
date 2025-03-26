package model;

public class Agendamento {
    private int id;
    private int usuarioId;
    private String data;
    private String hora;
    private String descricao;

    public Agendamento(int usuarioId, String data, String hora, String descricao) {
        this.usuarioId = usuarioId;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getDescricao() {
        return descricao;
    }
} 