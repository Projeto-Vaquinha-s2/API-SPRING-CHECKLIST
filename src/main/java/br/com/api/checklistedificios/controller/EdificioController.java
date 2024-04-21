package br.com.api.checklistedificios.controller;

import br.com.api.checklistedificios.dtos.EdificioRecordDto;
import br.com.api.checklistedificios.models.EdificioModel;
import br.com.api.checklistedificios.repositories.EdificioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("edificio")
public class EdificioController {
    @Autowired
    EdificioRepository edificioRepository;

    @PostMapping
    public ResponseEntity<EdificioModel> saveEdificio (@RequestBody @Valid EdificioRecordDto edificioRecordDto) {
        var edificioModel = new EdificioModel();
        BeanUtils.copyProperties(edificioRecordDto, edificioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(edificioRepository.save(edificioModel));
    }

    @GetMapping
    public ResponseEntity<List<EdificioModel>> getAllEdificio() {
        return ResponseEntity.status(HttpStatus.OK).body(edificioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct (@PathVariable(value="id") long id) {
        Optional<EdificioModel> edificioO = edificioRepository.findById(id);
        if (edificioO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edificio not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(edificioO.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEdifcio (@PathVariable (value="id") long id,
                                                 @RequestBody @Valid EdificioRecordDto edificioRecordDto) {
        Optional<EdificioModel> edificioO = edificioRepository.findById(id);
        if (edificioO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edificio not found.");
        }
        var edificioModel = edificioO.get();
        BeanUtils.copyProperties(edificioRecordDto, edificioModel);
        return ResponseEntity.status(HttpStatus.OK).body(edificioRepository.save(edificioModel));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteedificio (@PathVariable (value="id") long id) {
        Optional<EdificioModel> edificioO = edificioRepository.findById(id);
        if (edificioO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body ("Edificio not found.");
        }
        edificioRepository.delete(edificioO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Edificio deleted successfully.");
    }
}