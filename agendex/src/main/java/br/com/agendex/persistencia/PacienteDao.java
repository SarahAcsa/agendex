package br.com.agendex.persistencia;

import java.util.List;

import br.com.agendex.entidade.Paciente;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;

public interface PacienteDao extends Persistencia<Paciente>{

    List<Paciente> listarPorNomePaciente(String nome) throws PersistenciaException;

}
