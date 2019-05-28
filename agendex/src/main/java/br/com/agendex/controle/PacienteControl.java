package br.com.agendex.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.Paciente;
import br.com.agendex.persistencia.PacienteDao;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;


@Controller("PacienteControl")
@Scope("conversation")
public class PacienteControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Paciente paciente = new Paciente();
	
	
	private String nome;

	

	@Autowired
	private PacienteDao pacienteDao;
	

	private List<Paciente> pacientes = new ArrayList<Paciente>();
	private List<Paciente> pacientes2;
	
	private EntityManager manager;
	
	public PacienteControl() {
		// TODO Auto-generated constructor stub
	}
	

	public void confirmar(ActionEvent evt) {
		try {
			pacienteDao.alterar(paciente);
			listar(evt);
			paciente = new Paciente();
			
			
			 UtilFaces.addMensagemFaces("Paciente Salvo com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			pacientes = pacienteDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void listar2() {
		try {
			System.out.println("Entrou");
			if(nome != null && !nome.trim().equals("")) {
				pacientes2 = pacienteDao.listarPorNome(nome);
			}
			else{
				pacientes2 = pacienteDao.listar();
			}
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}
	
	public void setPacientes2(List<Paciente> pacientes2) {
		this.pacientes2 = pacientes2;
	}
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Paciente> getPacientes2() {
		if(pacientes2 == null) {
			try {
				System.out.println("GET");
				pacientes2 = pacienteDao.listar();
			} catch (PersistenciaException e) {
				pacientes2 = new ArrayList<Paciente>();
			}
		}
		return pacientes2;
	}

	public void setPacientess2(List<Paciente> pacientes2) {
		this.pacientes2 = pacientes2;
	}

	
}
