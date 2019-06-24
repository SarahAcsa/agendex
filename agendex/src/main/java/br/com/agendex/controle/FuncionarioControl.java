package br.com.agendex.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.Funcionario;
import br.com.agendex.persistencia.FuncionarioDao;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;

@Controller("FuncionarioControl")
@Scope("conversation")
public class FuncionarioControl {

    private Funcionario funcionario = new Funcionario();

    private Funcionario funcionarioExcluir;

    private String nome;
    

    private List<Funcionario> funcionarios = new ArrayList<>();

    
    public FuncionarioControl() {
		
	}
    

	@Autowired
    private FuncionarioDao FuncionarioDao;

    public void confirmar(ActionEvent evt){
        try {
        	FuncionarioDao.validar(funcionario);
        	FuncionarioDao.alterar(funcionario);
            UtilFaces.addMensagemFaces("Funcionario Cadastrado com sucesso!");
            funcionario = new Funcionario();
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void listarPorNomeFuncionario(){
        try {
        	funcionarios = FuncionarioDao.listarPorNomeFuncionario(this.nome);
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void excluir(){
        try {
        	FuncionarioDao.excluirPorId(funcionarioExcluir.getId());
        	listarPorNomeFuncionario();
            UtilFaces.addMensagemFaces("Excluído com sucesso!");
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioExcluir() {
		return funcionarioExcluir;
	}

	public void setFuncionarioExcluir(Funcionario funcionarioExcluir) {
		this.funcionarioExcluir = funcionarioExcluir;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}


}
