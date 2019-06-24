package br.com.agendex.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ambientinformatica.util.Entidade;

@Entity
public class AgendaMedico extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "agendaMedico_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "agendaMedico_seq", sequenceName = "agendaMedico_seq", allocationSize = 1, initialValue = 1)
	private Integer id;


	@Temporal(TemporalType.DATE)
	private Date dataDisponivel;
		
	@ManyToOne
	@JoinColumn(nullable = false)
	private Medico medico;
	
	
	
	
	@Override
	public Integer getId() {
		return id;
	}

	public Date getDataDisponivel() {
		return dataDisponivel;
	}

	public void setDataDisponivel(Date dataDisponivel) {
		this.dataDisponivel = dataDisponivel;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}



}