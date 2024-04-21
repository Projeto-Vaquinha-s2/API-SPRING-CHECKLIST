package br.com.api.checklistedificios.repositories;

import br.com.api.checklistedificios.models.SindicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface SindicoRepository extends JpaRepository <SindicoModel, Long> {


}