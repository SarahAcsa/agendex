package br.com.agendex.persistencia;

import java.util.List;

import br.com.agendex.entidade.Usuario;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;

public interface UsuarioDao extends Persistencia<Usuario>{

    List<Usuario> listarPorNome(String nome) throws PersistenciaException;

}
