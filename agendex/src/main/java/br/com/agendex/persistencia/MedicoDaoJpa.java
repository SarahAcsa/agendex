package br.com.agendex.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.agendex.entidade.Medico;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;


@Repository("medicoDao")

public class MedicoDaoJpa extends PersistenciaJpa<Medico> implements MedicoDao {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> listarPorNome(String nome) {
		List<Medico> lista;

		
		Query consultaNome = getEntityManager().createQuery(String.format("SELECT p FROM Medico p WHERE p.nome LIKE '%%%s%%'", nome));
		lista = consultaNome.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> listarPorEspecialidade(String categoria1) {
		List<Medico> lista2;

		
		Query consultacat = getEntityManager().createQuery(String.format("SELECT p FROM Medico p WHERE p.especialidade LIKE 'cardiologista'", categoria1));
		lista2 = consultacat.getResultList();
		return lista2;
	}

	
	
	
	
}
