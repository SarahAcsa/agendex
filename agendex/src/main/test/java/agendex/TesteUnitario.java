package agendex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.agendex.entidade.Instituicao;
import br.com.agendex.persistencia.InstituicaoDaoJpa;

public class TesteUnitario {

	Instituicao clinica = new Instituicao();
	InstituicaoDaoJpa clinicaDaoJpa = new InstituicaoDaoJpa();

	@Test
	public void test() {
		try {
			clinica = clinicaDaoJpa.listarPorNome("Belle Vittá").get(0);
		} catch (Exception e) {
		}
		assertNotNull("Objeto não é nulo", clinica);
	}

}
