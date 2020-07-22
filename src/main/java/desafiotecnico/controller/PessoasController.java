package desafiotecnico.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import desafiotecnico.dominio.Pessoas;
import desafiotecnico.repository.PessoasRepository;

@Controller
public class PessoasController {

	@Autowired
	private PessoasRepository repository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("lista")
	public String pessoas(Model model) {
		Iterable<Pessoas> pessoas = repository.findAll();
		model.addAttribute("pessoas", pessoas);
		return "lista";
	}
	
    @GetMapping("addPessoas")
    public String showSignUpForm(Pessoas pessoas) {
        return "addPessoas";
    }

    @RequestMapping(value="salvar", method=RequestMethod.POST)
    public String salvar(Pessoas pessoas, Model model){
    	Pessoas pessoa = repository.findByCpf(pessoas.getCpf());
    	if(pessoa == null) {
	    	pessoas.setData_cadastro(new Date());
	    	pessoas.setData_atualizacao(new Date());
	    	repository.save(pessoas);
    	}
    	return "redirect:/lista";
    }
    
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") int id, Model model){
        Optional<Pessoas> pessoa = repository.findById(id);
        repository.delete(pessoa.get());
        return "redirect:/lista";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Pessoas pessoa = repository.findById(id).get();
        model.addAttribute("pessoa", pessoa);
        return "updatePessoas";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") int id, Pessoas novaPessoa) {
    	Pessoas pessoa = repository.findById(id).get();
    	if(!novaPessoa.getCpf().equals(pessoa.getCpf())) {
    		Pessoas validaCpf = repository.findByCpf(novaPessoa.getCpf());
	    	if(validaCpf == null){
		    	novaPessoa.setId_pessoas(id);
		    	novaPessoa.setData_cadastro(pessoa.getData_cadastro());
		    	novaPessoa.setData_atualizacao(new Date());
		        repository.save(novaPessoa);
	    	}
    	}
    	else {
	    	novaPessoa.setId_pessoas(id);
	    	novaPessoa.setData_cadastro(pessoa.getData_cadastro());
	    	novaPessoa.setData_atualizacao(new Date());
	        repository.save(novaPessoa);
    	}
        return "redirect:/lista";
    }
}