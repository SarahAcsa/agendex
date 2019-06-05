package br.com.agendex.persistencia;

import java.util.List;

import br.com.agendex.entidade.Funcionario;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;

public interface FuncionarioDao extends Persistencia<Funcionario>{

    List<Funcionario> listarPorNomeFuncionario(String nome) throws PersistenciaException;

}
