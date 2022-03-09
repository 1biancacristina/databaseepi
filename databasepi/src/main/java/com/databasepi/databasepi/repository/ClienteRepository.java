package com.databasepi.databasepi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.databasepi.databasepi.models.Cliente;

public interface ClienteRepository extends CrudRepository <Cliente, String> {

	Cliente findByCpf(long cpf);
	List<Cliente>findByNome(String nome);
	
	@Query(value = "select u from Cliente u where u.nome like %?1%")
	List<Cliente>findByNomes(String nome);
}


	