package br.com.agendex.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.AgendaMedico;
import br.com.agendex.entidade.Medico;
import br.com.agendex.persistencia.MedicoDao;


@Controller("AgendaControl")
@Scope("conversation")
public class AgendaControl {
	
	private ScheduleModel agenda;
	private AgendaMedico agemedico;
	private List<Medico> medicos = new ArrayList<Medico>();
	private List<Medico> especialidades = new ArrayList<Medico>();
	private String teste;
	
	@Autowired
	private MedicoDao medicoDao2;
	
	@PostConstruct
	public void listar() {
		agenda = new DefaultScheduleModel();
	}
	
	
	public void novo(SelectEvent evento) {
		agemedico= new AgendaMedico();
		agemedico.setDataDisponivel((Date)evento.getObject());
		
		try {
			especialidades = medicoDao2.listarPorEspecialidade(teste);
			//medicos = medicoDao2.listarPorNomeMedico("");
		} catch (Exception e) {
			
		}
		
	}
	
	public void novo2(SelectEvent evento) {
			
		try {
			especialidades = medicoDao2.listarPorEspecialidade(teste);
			//medicos = medicoDao2.listarPorNomeMedico("");
		} catch (Exception e) {
			
		}
		
	}
	
	
	 public ScheduleModel getEventModel() {
		return agenda;
	}

	public void setEventModel(ScheduleModel agenda) {
		this.agenda = agenda;
	}


	public AgendaMedico getAgemedico() {
		return agemedico;
	}


	public void setAgemedico(AgendaMedico agemedico) {
		this.agemedico = agemedico;
	}

	public ScheduleModel getAgenda() {
		return agenda;
	}


	public void setAgenda(ScheduleModel agenda) {
		this.agenda = agenda;
	}


	public MedicoDao getMedicoDao2() {
		return medicoDao2;
	}


	public void setMedicoDao2(MedicoDao medicoDao2) {
		this.medicoDao2 = medicoDao2;
	}


	public List<Medico> getMedicos() {
		return medicos;
	}


	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}


	public List<Medico> getEspecialidades() {
		return especialidades;
	}


	public void setEspecialidades(List<Medico> especialidades) {
		this.especialidades = especialidades;
	}


	public String getTeste() {
		return teste;
	}


	public void setTeste(String teste) {
		this.teste = teste;
	}
	
	
	
	
	 
}
