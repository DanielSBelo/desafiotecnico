package desafiotecnico.test;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import desafiotecnico.dominio.Pessoas;
import desafiotecnico.repository.PessoasRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TesteDados {

	@Autowired
	private PessoasRepository pessoasRepository;
	
    @Test
    public void checkInsert() throws Exception {
    	Pessoas pessoa = new Pessoas("Teste1", "masc", "teste@teste.com.br", "Rua Teste",
    			"2000-01-01", "BQ", "Brasil", "111.222.333-44", new Date(), new Date());
    	pessoasRepository.save(pessoa);
        Integer count = pessoasRepository.findAll().size();
        assertEquals(1, count);
    }
    
    @Test
    public void checkPessoaSavedCPF() {
    	Pessoas pessoa = new Pessoas("Teste1", "masc", "teste@teste.com.br", "Rua Teste",
    			"2000-01-01", "BQ", "Brasil", "111.222.333-44", new Date(), new Date());
    	pessoasRepository.save(pessoa);
        Integer count = pessoasRepository.findAll().size();
        assertEquals(1, count);
        Pessoas pessoa1 = pessoasRepository.findByCpf("111.222.333-44");

        assertNotNull(pessoa1);
        assertEquals(pessoa, pessoa1);
    }
}
