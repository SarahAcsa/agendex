package br.com.agendex.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.agendex.entidade.Paciente;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;


@Repository("pacienteDao")
public class PacienteDaoJpa extends PersistenciaJpa<Paciente> implements PacienteDao {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> listarPorNome(String nome) {
		List<Paciente> lista;

		Query consultaNome = getEntityManager()
				.createQuery(String.format("SELECT p FROM paciente p WHERE p.nome LIKE '%s%'", nome));
		lista = consultaNome.getResultList();
		return lista;

	}
}
