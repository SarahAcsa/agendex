package br.com.agendex.persistencia;

import java.util.List;

import br.com.agendex.entidade.Instituicao;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;

public interface InstituicaoDao extends Persistencia<Instituicao>{

    List<Instituicao> listarPorNome(String nome) throws PersistenciaException;

}
