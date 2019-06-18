package br.com.agendex.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.ambientinformatica.jpa.util.AlfaNumerico;
import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;
import br.com.ambientinformatica.util.UtilHash;
import br.com.ambientinformatica.util.UtilHash.Algoritimo;

@Entity
public class Usuario extends Entidade implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
	@NotEmpty(message="Login do usuário é obrigatório", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false, unique = true)
    @Length(min = 0, max = 255, message = "O limite do campo e-mail do paciente é de 255 caracteres.", groups = AmbientValidator.class)
    private String login;

    @NotNull
    @NotEmpty
    private String senha;  

    @Temporal(TemporalType.DATE)
    private Date dataAlteracaoSenha = new Date();

    @Temporal(TemporalType.DATE)
    private Date dataCriacao = new Date();

    @Temporal(TemporalType.DATE)
    private Date dataUltimoAcesso = new Date();

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="usuario_id")
    private Set<PapelUsuario> papeis = new HashSet<PapelUsuario>();

    public boolean isContemPapel(EnumPapelUsuario papel){
        for(PapelUsuario p : papeis){
            if(p.getPapel() == papel){
                return true;
            }
        }
        return false;
    }

    public List<PapelUsuario> getPapeisList() {
        List<PapelUsuario> result = new ArrayList<PapelUsuario>(papeis);
        Collections.sort(result);
        return result;
    }

    public void addPapel(EnumPapelUsuario papel){
        if(!isContemPapel(papel)){
            PapelUsuario pu = new PapelUsuario();
            pu.setPapel(papel);
            papeis.add(pu);
        }
    }

    public void resetarSenha(){
        setSenhaNaoCriptografada("123456");
    }

    public void setSenhaNaoCriptografada(String senha) {
        this.senha = UtilHash.gerarStringHash(senha, Algoritimo.MD5);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
		 this.login = login;
		
	}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPapeis(Set<PapelUsuario> papeis) {
        this.papeis = papeis;
    }


    public Date getDataAlteracaoSenha() {
        return dataAlteracaoSenha;
    }

    public void setDataAlteracaoSenha(Date dataAlteracaoSenha) {
        this.dataAlteracaoSenha = dataAlteracaoSenha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Date dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public Set<PapelUsuario> getPapeis() {
        return papeis;
    }

    public Object getId() {
        return login;
    }
}