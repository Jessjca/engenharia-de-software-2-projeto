

public class Agendamento {
    private Usuario usuario;
    private String data;
    private String hora;
    private String descricao;

    public Agendamento(Usuario usuario, String data, String hora, String descricao) {
        this.usuario = usuario;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
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