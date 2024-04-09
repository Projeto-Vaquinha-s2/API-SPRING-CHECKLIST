package br.com.api.checklistedificios.controller;

import br.com.api.checklistedificios.dtos.AdmRecordDto;
import br.com.api.checklistedificios.dtos.SindicoRecordDto;
import br.com.api.checklistedificios.models.AdmModel;
import br.com.api.checklistedificios.models.SindicoModel;
import br.com.api.checklistedificios.repositories.AdmRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administrador")
public class AdmController {
    @Autowired
    AdmRepository admRepository;

    @PostMapping
    public ResponseEntity<AdmModel> saveAdm (@RequestBody @Valid AdmRecordDto admRecordDto) {
        var admModel = new AdmModel();
        BeanUtils.copyProperties(admRecordDto, admModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(admRepository.save(admModel));
    }

    @GetMapping
    public ResponseEntity<List<AdmModel>> getAllAdm() {
        return ResponseEntity.status(HttpStatus.OK).body(admRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct (@PathVariable(value="id") long id) {
        Optional<AdmModel> admO = admRepository.findById(id);
        if (admO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adm not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(admO.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAdm (@PathVariable (value="id") long id,
                                                 @RequestBody @Valid AdmRecordDto admRecordDto) {
        Optional<AdmModel> admO = admRepository.findById(id);
        if (admO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adm not found.");
        }
        var admModel = admO.get();
        BeanUtils.copyProperties(admRecordDto, admModel);
        return ResponseEntity.status(HttpStatus.OK).body(admRepository.save(admModel));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdm (@PathVariable (value="id") long id) {
        Optional<AdmModel> admO = admRepository.findById(id);
        if (admO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body ("Adm not found.");
        }
        admRepository.delete(admO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Adm deleted successfully.");
    }

}