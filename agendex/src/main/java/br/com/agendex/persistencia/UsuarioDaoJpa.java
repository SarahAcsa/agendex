package br.com.agendex.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.agendex.entidade.Usuario;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;

@Repository("usuarioDao")
public class UsuarioDaoJpa extends PersistenciaJpa<Usuario> implements UsuarioDao{

    private static final long serialVersionUID = 1L;

    @Override
    public List<Usuario> listarPorNome(String nome) throws PersistenciaException {
        try {
            String sql = "select distinct u from Usuario u where 1=1 ";

            if(nome != null && !nome.isEmpty()){
                sql += " and upper(u.nome) like upper(:nome)";
            }

            TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);

            if(nome != null && !nome.isEmpty()){
                query.setParameter("nome", "%" + nome + "%");
            }

            return query.getResultList();

        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao listar usuários", e);
        }
    }

}
