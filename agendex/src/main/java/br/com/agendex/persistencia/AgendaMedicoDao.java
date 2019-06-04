package br.com.agendex.persistencia;

import java.util.List;

import br.com.agendex.entidade.AgendaMedico;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;

public interface AgendaMedicoDao extends Persistencia<AgendaMedico>{

	List<AgendaMedico> listarPorData(String data) throws PersistenciaException;
}
