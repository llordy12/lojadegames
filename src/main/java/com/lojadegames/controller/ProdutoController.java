package com.lojadegames.controller;

import com.lojadegames.model.Produtos;
import com.lojadegames.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produtos> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produtos adicionar(@RequestBody Produtos produto) {
        return repository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizar(@PathVariable Long id, @RequestBody Produtos produtos) {
        return repository.findById(id)
                .map(p -> {
                    produtos.setId(p.getId());
                    return ResponseEntity.ok(repository.save(produtos));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
