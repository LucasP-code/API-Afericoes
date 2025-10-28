package application.afericoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AfericaoService {
    @Autowired
    private AfericaoRepository afericaoRepo;

    public Iterable<AfericaoDTO> getAll() {
        return afericaoRepo.findAll().stream().map(AfericaoDTO::new).toList();
    }

    public AfericaoDTO insert(AfericaoInsertDTO novaAfericao) {

        Afericao afericao = new Afericao();
        afericao.setId_sensor(novaAfericao.id_sensor());
        afericao.setUnidade(novaAfericao.unidade());
        afericao.setValor(novaAfericao.valor());

        return new AfericaoDTO(afericaoRepo.save(afericao));
    }

    public AfericaoDTO getOne(Long id) {
        Optional<Afericao> resultado = afericaoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Afericao nao encontrada"
            );
        }

        return new AfericaoDTO(resultado.get());
    }

    public AfericaoDTO update(long id, AfericaoInsertDTO novosDados) {
        Optional<Afericao> resultado = afericaoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Afericao nao encontrada"
            );
        }

        resultado.get().setId_sensor(novosDados.id_sensor());
        resultado.get().setUnidade(novosDados.unidade());
        resultado.get().setValor(novosDados.valor());

        return new AfericaoDTO(afericaoRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!afericaoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Afericao nao encontrada"
            );
        }

        afericaoRepo.deleteById(id);
    }

}
