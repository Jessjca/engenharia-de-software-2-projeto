public class Agendamento {
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

    public boolean validarData(String data) {
        if (data == null || !data.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }
        try {
            java.time.LocalDate dataAgendamento = java.time.LocalDate.parse(data);
            java.time.LocalDate hoje = java.time.LocalDate.now();
            return data.equals(this.data) || !dataAgendamento.isBefore(hoje);
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }

    public boolean validarHora(String hora) {
        if (hora == null || !hora.matches("\\d{2}:\\d{2}")) {
            return false;
        }
        try {
            java.time.LocalTime.parse(hora);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }
} 