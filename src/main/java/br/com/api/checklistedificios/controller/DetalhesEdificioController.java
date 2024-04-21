package br.com.api.checklistedificios.controller;

import br.com.api.checklistedificios.dtos.DetalhesEdificioRecordDto;
import br.com.api.checklistedificios.models.DetalhesEdificioModel;
import br.com.api.checklistedificios.repositories.DetalhesEdificioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalhes-edificio")
public class DetalhesEdificioController {

    @Autowired
    DetalhesEdificioRepository detalhesEdificioRepository;

    @PostMapping
    public ResponseEntity<DetalhesEdificioModel> saveDetalhesEdificio(@RequestBody @Valid DetalhesEdificioRecordDto detalhesEdificioRecordDto) {
        var detalhesEdificio = new DetalhesEdificioModel();
        BeanUtils.copyProperties(detalhesEdificioRecordDto, detalhesEdificio);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhesEdificioRepository.save(detalhesEdificio));
    }

    @GetMapping
    public ResponseEntity<List<DetalhesEdificioModel>> getAllDetalhesEdificio() {
        return ResponseEntity.status(HttpStatus.OK).body(detalhesEdificioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetalhesEdificioById(@PathVariable(value="id") long id) {
        Optional<DetalhesEdificioModel> detalhesEdificioOptional = detalhesEdificioRepository.findById(id);
        if (detalhesEdificioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalhes do edifício não encontrados.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(detalhesEdificioOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDetalhesEdificio(@PathVariable(value="id") long id,
                                                         @RequestBody @Valid DetalhesEdificioRecordDto detalhesEdificioRecordDto) {
        Optional<DetalhesEdificioModel> detalhesEdificioOptional = detalhesEdificioRepository.findById(id);
        if (detalhesEdificioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalhes do edifício não encontrados.");
        }
        DetalhesEdificioModel detalhesEdificio = detalhesEdificioOptional.get();
        BeanUtils.copyProperties(detalhesEdificioRecordDto, detalhesEdificio);
        return ResponseEntity.status(HttpStatus.OK).body(detalhesEdificioRepository.save(detalhesEdificio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDetalhesEdificio(@PathVariable(value="id") long id) {
        Optional<DetalhesEdificioModel> detalhesEdificioOptional = detalhesEdificioRepository.findById(id);
        if (detalhesEdificioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalhes do edifício não encontrados.");
        }
        detalhesEdificioRepository.delete(detalhesEdificioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Detalhes do edifício deletados com sucesso.");
    }
}
