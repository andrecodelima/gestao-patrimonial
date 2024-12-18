package net.sys.gest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.sys.gest.model.Acesso;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

	@Query("SELECT a FROM Acesso a WHERE upper (trim(a.descricao)) LIKE %?1%")
	List<Acesso>buscarAcessoDesc(String desc);
	
}
