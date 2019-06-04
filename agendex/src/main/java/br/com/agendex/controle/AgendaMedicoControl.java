package br.com.agendex.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.AgendaMedico;
import br.com.agendex.persistencia.AgendaMedicoDao;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;

@Controller("AgendaMedicoControl")
@Scope("conversation")
public class AgendaMedicoControl {

	private AgendaMedico agendaMedico = new AgendaMedico();
	
	private AgendaMedico agendaExcluir;
	
	private String data;
	
	private List<AgendaMedico> agendaMedicos = new ArrayList<>();
	
	@Autowired
	private AgendaMedicoDao agendaMedicoDao;
	
	@PostConstruct
    public void init(){
        listar();
    }
	
	public void confirmar(ActionEvent evt){
        try {
        	//agendaMedicoDao.validar(agendaMedico);
        	agendaMedicoDao.alterar(agendaMedico);
            UtilFaces.addMensagemFaces("Dados Cadastrado na Agenda com sucesso!");
            agendaMedico = new AgendaMedico();
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }
	
	
	public void listaPorData() {
	
		 try {
			 agendaMedicos = agendaMedicoDao.listarPorData(this.data);
	        } catch (Exception e) {
	            UtilFaces.addMensagemFaces(e);
	        }
		
	}
	
	public void listar(){
        try {
        	agendaMedicos = agendaMedicoDao.listar();
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }
	public void excluir(){
        try {
        	agendaMedicoDao.excluirPorId(agendaExcluir.getId());
        	listar();
            UtilFaces.addMensagemFaces("Horario Excluído com sucesso!");
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }
	
	

	public AgendaMedico getAgendaMedico() {
		return agendaMedico;
	}


	public void setAgendaMedico(AgendaMedico agendaMedico) {
		this.agendaMedico = agendaMedico;
	}


	public AgendaMedico getAgendaExcluir() {
		return agendaExcluir;
	}


	public void setAgendaExcluir(AgendaMedico Excluir) {
		agendaExcluir = Excluir;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public List<AgendaMedico> getAgendaMedicos() {
		return agendaMedicos;
	}


}
