package br.com.agendex.persistencia;

import java.util.List;

import br.com.agendex.entidade.Medico;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;

public interface MedicoDao extends Persistencia<Medico>{

    List<Medico> listarPorNomeMedico(String nome) throws PersistenciaException;
    List<Medico> listarPorEspecialidade(String nome) throws PersistenciaException;
}
