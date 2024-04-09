package br.com.api.checklistedificios.controller;

import br.com.api.checklistedificios.dtos.AdmRecordDto;
import br.com.api.checklistedificios.dtos.SindicoRecordDto;
import br.com.api.checklistedificios.models.AdmModel;
import br.com.api.checklistedificios.models.SindicoModel;
import br.com.api.checklistedificios.repositories.AdmRepository;
import br.com.api.checklistedificios.repositories.SindicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sindico")
public class SindicoController {
    @Autowired
    SindicoRepository sindicoRepository;

    @PostMapping
    public ResponseEntity<SindicoModel> saveSindico (@RequestBody @Valid SindicoRecordDto sindicoRecordDto) {
        var sindicoModel = new SindicoModel();
        BeanUtils.copyProperties(sindicoRecordDto, sindicoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(sindicoRepository.save(sindicoModel));
    }

    @GetMapping
    public ResponseEntity<List<SindicoModel>> getAllSindico() {
        return ResponseEntity.status(HttpStatus.OK).body(sindicoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct (@PathVariable(value="id") long id) {
        Optional<SindicoModel> sindicoO = sindicoRepository.findById(id);
        if (sindicoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sindico not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(sindicoO.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSindico (@PathVariable (value="id") long id,
                                                 @RequestBody @Valid SindicoRecordDto sindicoRecordDto) {
        Optional<SindicoModel> sindicoO = sindicoRepository.findById(id);
        if (sindicoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sindico not found.");
        }
            var sindicoModel = sindicoO.get();
            BeanUtils.copyProperties(sindicoRecordDto, sindicoModel);
            return ResponseEntity.status(HttpStatus.OK).body(sindicoRepository.save(sindicoModel));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSindico (@PathVariable (value="id") long id) {
        Optional<SindicoModel> sindicoO = sindicoRepository.findById(id);
        if (sindicoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body ("Sindico not found.");
        }
        sindicoRepository.delete(sindicoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Sindico deleted successfully.");
    }

    }