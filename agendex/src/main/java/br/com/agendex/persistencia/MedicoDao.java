package br.com.agendex.persistencia;

import java.util.List;

import br.com.agendex.entidade.Medico;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;


public interface MedicoDao extends Persistencia<Medico>{

	List<Medico> listarPorNome(String nome);
	List<Medico> listarPorEspecialidade(String categoria1);
	
}