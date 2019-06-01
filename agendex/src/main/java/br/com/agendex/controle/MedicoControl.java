package br.com.agendex.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.agendex.entidade.Medico;
import br.com.agendex.persistencia.MedicoDao;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;

@Controller("MedicoControl")
@Scope("conversation")
public class MedicoControl {

    private Medico medico = new Medico();

    private Medico medicoExcluir;

    private String nome;

    private List<Medico> medicos = new ArrayList<>();

    @Autowired
    private MedicoDao MedicoDao;

    public void confirmar(ActionEvent evt){
        try {
        	MedicoDao.validar(medico);
        	MedicoDao.alterar(medico);
            UtilFaces.addMensagemFaces("Medico Cadastrado com sucesso!");
            medico = new Medico();
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void listarPorNomePaciente(){
        try {
        	medicos = MedicoDao.listarPorNomeMedico(this.nome);
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void excluir(){
        try {
        	MedicoDao.excluirPorId(medicoExcluir.getId());
        	listarPorNomePaciente();
            UtilFaces.addMensagemFaces("Excluído com sucesso!");
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

    public List<Medico> getMedicos() {
        return medicos;
    }

    public Medico getmedicoExcluir() {
        return medicoExcluir;
    }

    public void setmedicoExcluir(Medico medicoExcluir) {
        this.medicoExcluir = medicoExcluir;
    }

}
