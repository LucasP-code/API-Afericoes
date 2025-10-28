package application.afericoes;

public record AfericaoInsertDTO(String id_sensor, String unidade, String valor) {
    public AfericaoInsertDTO(Afericao dados) {
        this(dados.getId_sensor(), dados.getUnidade(), dados.getValor());
    }
}
