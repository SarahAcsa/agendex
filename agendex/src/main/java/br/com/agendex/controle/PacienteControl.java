package br.com.agendex.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.Paciente;
import br.com.agendex.entidade.Usuario;
import br.com.agendex.persistencia.PacienteDao;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;

@Controller("PacienteControl")
@Scope("conversation")
public class PacienteControl {

    private Paciente paciente = new Paciente();

    private Paciente pacienteExcluir;

    private String nome;
    
    private Usuario usuario = new Usuario();

    private List<Paciente> pacientes = new ArrayList<>();

    @Autowired
    private PacienteDao PacienteDao;

    public void confirmar(ActionEvent evt){
        try {
        	PacienteDao.validar(paciente);
            PacienteDao.alterar(paciente);
            UtilFaces.addMensagemFaces("Paciente Cadastrado com sucesso!");
            paciente = new Paciente();
            
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void listarPorNomePaciente(){
        try {
        	pacientes = PacienteDao.listarPorNomePaciente(this.nome);
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void excluir(){
        try {
        	PacienteDao.excluirPorId(pacienteExcluir.getId());
        	listarPorNomePaciente();
            UtilFaces.addMensagemFaces("Excluído com sucesso!");
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public Paciente getpacienteExcluir() {
        return pacienteExcluir;
    }

    public void setpacienteExcluir(Paciente pacienteExcluir) {
        this.pacienteExcluir = pacienteExcluir;
    }

}