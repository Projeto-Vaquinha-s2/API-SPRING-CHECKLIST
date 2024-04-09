package br.com.api.checklistedificios.repositories;

import br.com.api.checklistedificios.models.AdmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdmRepository extends JpaRepository<AdmModel, Long> {



}

