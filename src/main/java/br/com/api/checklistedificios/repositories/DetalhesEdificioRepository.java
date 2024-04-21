package br.com.api.checklistedificios.repositories;

import br.com.api.checklistedificios.models.DetalhesEdificioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalhesEdificioRepository extends JpaRepository <DetalhesEdificioModel, Long> {


}