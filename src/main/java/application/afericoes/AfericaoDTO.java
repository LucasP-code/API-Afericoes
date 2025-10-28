package application.afericoes;

public record AfericaoDTO(Long id, String id_sensor, String unidade, String valor) {
    public AfericaoDTO(Afericao dados) {
        this(dados.getId(), dados.getId_sensor(), dados.getUnidade(), dados.getValor());
    }
}
