package desafiotecnico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafiotecnico.dominio.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Integer> {

	public Pessoas findByCpf(String cpf);
}