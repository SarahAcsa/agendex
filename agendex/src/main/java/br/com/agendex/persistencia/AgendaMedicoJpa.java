package br.com.agendex.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.agendex.entidade.AgendaMedico;
import br.com.agendex.entidade.Medico;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;

@Repository("AgendaMedicoDao")
public class AgendaMedicoJpa extends PersistenciaJpa<AgendaMedico> implements AgendaMedicoDao {

	private static final long serialVersionUID = 1L;

	@Override
	public List<AgendaMedico> listarPorData(String dataDisponivel) throws PersistenciaException {
		try {
			String sql = "select distinct i from AgendaMedico i where 1=1 ";

			if (dataDisponivel != null && !dataDisponivel.isEmpty()) {
				sql += " and upper(i.dataDisponivel) like upper(:dataDisponivel)";
			}

			TypedQuery<AgendaMedico> query = em.createQuery(sql, AgendaMedico.class);

			if (dataDisponivel != null && !dataDisponivel.isEmpty()) {
				query.setParameter("dataDisponivel", "%" + dataDisponivel + "%");
			}

			return query.getResultList();

		} catch (Exception e) {
			UtilLog.getLog().error(e.getMessage(), e);
			throw new PersistenciaException("Erro ao listar medicos", e);
		}
	}
	
	


}
