package net.sys.gest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sys.gest.model.Ausencia;

@Repository
public interface AusenciaRepository extends JpaRepository<Ausencia, Long> {

}
