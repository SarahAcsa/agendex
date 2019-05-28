package br.com.agendex.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.Medico;
import br.com.agendex.persistencia.MedicoDao;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;


@Controller("MedicoControl")
@Scope("conversation")
public class MedicoControl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Medico medico = new Medico(); 
	private String nome;
	private String categoria1;
	
	@Autowired
	private MedicoDao medicoDao;
	
	private List<Medico> medicos = new ArrayList<Medico>();
	private List<Medico> medicos2;
	
	private EntityManager manager;
	
//	@PostConstruct
//	   public void init(){
//	      listar(null);
//	   }
	
	public MedicoControl() {
//		listar2();
	}
	
	public void confirmar(ActionEvent evt) {
		try {
			medicoDao.alterar(medico);
			listar(evt);
			medico = new Medico();
			 UtilFaces.addMensagemFaces("Médico Salvo com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void listar(ActionEvent evt) {
		try {
			medicos = medicoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	
	public void listar2() {
		try {
			System.out.println("Entrou");
			if(nome != null && !nome.trim().equals("")) {
				medicos2 = medicoDao.listarPorNome(nome);
			}
			else{
				medicos2 = medicoDao.listar();
			}
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void listar3() {
		try {
			
			medicos2 = medicoDao.listarPorEspecialidade(categoria1);

		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public MedicoDao getMedicoDao() {
		return medicoDao;
	}

	public void setMedicoDao(MedicoDao medicoDao) {
		this.medicoDao = medicoDao;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Medico> getMedicos2() {
		if(medicos2 == null) {
			try {
				System.out.println("GET");
				medicos2 = medicoDao.listar();
			} catch (PersistenciaException e) {
				medicos2 = new ArrayList<Medico>();
			}
		}
		return medicos2;
	}

	public void setProdutos2(List<Medico> medicos2) {
		this.medicos2 = medicos2;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	
	
	
	
}
