package br.com.api.checklistedificios.repositories;

import br.com.api.checklistedificios.models.EdificioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<EdificioModel, Long> {
}
