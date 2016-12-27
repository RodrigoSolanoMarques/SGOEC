package br.edu.utfpr.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
