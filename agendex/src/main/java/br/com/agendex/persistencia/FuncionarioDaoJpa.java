package br.com.agendex.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.agendex.entidade.Funcionario;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;

@Repository("FuncionarioDao")
public class FuncionarioDaoJpa extends PersistenciaJpa<Funcionario> implements FuncionarioDao{

    private static final long serialVersionUID = 1L;

    @Override
    public List<Funcionario> listarPorNomeFuncionario(String nome) throws PersistenciaException {
        try {
            String sql = "select distinct i from Funcionario i where 1=1 ";

            if(nome != null && !nome.isEmpty()){
                sql += " and upper(i.nome) like upper(:nome)";
            }

            TypedQuery<Funcionario> query = em.createQuery(sql, Funcionario.class);

            if(nome != null && !nome.isEmpty()){
                query.setParameter("nome", "%" + nome + "%");
            }

            return query.getResultList();

        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao listar funcionarios", e);
        }
    }

}


