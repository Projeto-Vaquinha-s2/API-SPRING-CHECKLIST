package com.api.checklistcondominio.controller;

import com.api.checklistcondominio.domain.adiministrador.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("administradores")
public class AdministradorController {
    @Autowired
    private AdministradorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAdministrador dados, UriComponentsBuilder uriBuilder) {
        var administrador = new Administrador(dados);
        repository.save(administrador);

        var uri = uriBuilder.path("/administradores/{id}").buildAndExpand(administrador.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAdministrador(administrador));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAdministrador>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAdministrador::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAdministrador dados) {
        var administrador = repository.getReferenceById(dados.id());
        administrador.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAdministrador(administrador));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var administrador = repository.getReferenceById(id);
        administrador.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var administrador = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAdministrador(administrador));
    }
}
