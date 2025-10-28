package application.afericoes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Afericoes")
@Setter
@Getter
@NoArgsConstructor
public class Afericao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String id_sensor;
    @Column(nullable = false)
    private String unidade;
    @Column(nullable = false)
    private String valor;

    public Afericao(AfericaoDTO dados) {
        this.setId(dados.id());
        this.setId_sensor(dados.id_sensor());
        this.setUnidade(dados.unidade());
        this.setValor(dados.valor());
    }

    public Afericao(AfericaoInsertDTO dados) {
        this.setId_sensor(dados.id_sensor());
        this.setUnidade(dados.unidade());
        this.setValor(dados.valor());
    }

}
