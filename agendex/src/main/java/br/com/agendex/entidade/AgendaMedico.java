package br.com.agendex.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
public class AgendaMedico extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "agendaMedico_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "agendaMedico_seq", sequenceName = "agendaMedico_seq", allocationSize = 1, initialValue = 1)
	private Integer id;


	@NotEmpty(message = "Informe a Data disponivel para atendimento..", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false, unique = true)
	@Length(min = 0, max = 255, message = "O limite do campo data Disponivel  é de 255 caracteres.", groups = AmbientValidator.class)
	private String dataDisponivel;

	@NotEmpty(message = "Informe a Hora disponivel para atendimento.", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false, unique = true)
	@Length(min = 0, max = 255, message = "O limite do campo hora Disponivel  é de 255 caracteres.", groups = AmbientValidator.class)
	private String horaDisponivel;
	
	@Override
	public Integer getId() {
		return id;
	}

	public String getDataDisponivel() {
		return dataDisponivel;
	}

	public void setDataDisponivel(String dataDisponivel) {
		this.dataDisponivel = dataDisponivel;
	}

	public String getHoraDisponivel() {
		return horaDisponivel;
	}

	public void setHoraDisponivel(String horaDisponivel) {
		this.horaDisponivel = horaDisponivel;
	}


}