package net.sys.gest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.TestCase;
import net.sys.gest.controller.AcessoController;
import net.sys.gest.model.Acesso;
import net.sys.gest.repository.AcessoRepository;

@SpringBootTest(classes = SistemaGestaoApplication.class)
public class SistemaGestaoApplicationTests extends TestCase {

	@Autowired
	private AcessoController acessoController;
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	
	@Test
	public void testeCadastraAcesso() {
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ADM");
		
		// Gravação no banco
		acesso = acessoController.saveAcesso(acesso).getBody();
		
		assertEquals(true, acesso.getId() > 0);
		
		// Validar dados salvos
		assertEquals("ROLE_ADM", acesso.getDescricao());
		
		// Teste de carregamento
				Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();
				assertEquals(acesso.getId(), acesso2.getId());
				
				// Teste Delete
				acessoRepository.deleteById(acesso2.getId());
				acessoRepository.flush();
				Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null);
				
				assertEquals(true, acesso3 == null);
				
				
				// Teste de Query
				acesso = new Acesso();
				acesso.setDescricao("ROLE_USER");
				acesso = acessoController.saveAcesso(acesso).getBody();
				List<Acesso> acessos = acessoRepository.buscarAcessoDesc("USER".trim().toUpperCase());
				
				assertEquals(1, acessos.size());
//				acessoRepository.deleteById(acesso.getId());
	}
	
	
	
 

}
