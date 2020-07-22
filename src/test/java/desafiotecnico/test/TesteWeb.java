package desafiotecnico.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import desafiotecnico.controller.PessoasController;
import desafiotecnico.dominio.Pessoas;
import desafiotecnico.repository.PessoasRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PessoasController.class)
public class TesteWeb {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoasRepository pessoasRepository;
    
    @Test
    public void findAllPessoa() throws Exception {
    	Pessoas pessoa = new Pessoas("Teste1", "masc", "teste@teste.com.br", "Rua Teste",
    			"2000-01-01", "BQ", "Brasil", "111.222.333-44", new Date(), new Date());
        List<Pessoas> pessoaList = new ArrayList<Pessoas>();
        pessoaList.add(pessoa);
        when(pessoasRepository.findAll()).thenReturn(pessoaList);
        this.mockMvc.perform((RequestBuilder) ((ResultActions) get(("/lista")))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Teste"))));
    }
}
