package net.sys.gest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sys.gest.model.Empresa;

@Repository
public interface FuncionarioRepository extends JpaRepository<Empresa, Long> {

}
