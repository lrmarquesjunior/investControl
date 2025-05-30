package br.com.invest.investControl.controller;

import br.com.invest.investControl.entity.AtivosEntity;
import br.com.invest.investControl.service.AtivosService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        origins = {"http://localhost:8081"}
)
@RestController
@RequestMapping({"/ativos"})
public class AtivosController {
    private final AtivosService ativosService;

    @Autowired
    public AtivosController(AtivosService ativosService) {
        this.ativosService = ativosService;
    }

    @PostMapping
    public ResponseEntity<AtivosEntity> criarAtivo(@RequestBody AtivosEntity ativo) {
        System.out.println("Recebido: " + String.valueOf(ativo));
        return ResponseEntity.ok(this.ativosService.salvarAtivo(ativo));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<AtivosEntity> buscarAtivo(@PathVariable UUID id) {
        return (ResponseEntity)this.ativosService.buscarPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<AtivosEntity> listarTodos() {
        return this.ativosService.listarTodos();
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletarAtivo(@PathVariable UUID id) {
        this.ativosService.deletarAtivo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping({"/nome/{nomeAtivo}"})
    public ResponseEntity<List<AtivosEntity>> buscarPorNome(@PathVariable String nomeAtivo) {
        return ResponseEntity.ok(this.ativosService.buscarPorNome(nomeAtivo));
    }

    @DeleteMapping({"/nome/{nomeAtivo}"})
    public ResponseEntity<Void> deletarPorNome(@PathVariable String nomeAtivo) {
        this.ativosService.deletarPorNome(nomeAtivo);
        return ResponseEntity.noContent().build();
    }
}

