package application.afericoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/afericoes")
public class AfericaoController {
    @Autowired
    private AfericaoService afericaoService;

    @GetMapping
    public Iterable<AfericaoDTO> getAll() {
        return this.afericaoService.getAll();
    }

    @PostMapping
    public AfericaoDTO insert(@RequestBody AfericaoInsertDTO dadosNovos) {
        return this.afericaoService.insert(dadosNovos);
    }

    @PutMapping("/{id}")
    public AfericaoDTO update (@PathVariable long id, @RequestBody AfericaoInsertDTO dados) {
        return this.afericaoService.update(id, dados);
    }

    @GetMapping("/{id}")
    public AfericaoDTO getOne(@PathVariable long id) {
        return this.afericaoService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        this.afericaoService.delete(id);
    }
}
