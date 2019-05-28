package br.com.agendex.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ambientinformatica.jpa.util.CpfCnpj;

@Entity
public class Medico {

	   @Id
	   @GeneratedValue(generator="medico_seq", strategy=GenerationType.SEQUENCE)
	   @SequenceGenerator(name="medico_seq", sequenceName="medico_seq", allocationSize=1, initialValue=1)
	   private Integer id;
	   
	   //private Usuario usuario_id;
	
	private String nome;
	private String especialidade;
	@CpfCnpj
	private String cpf;
	private String crm;
	
	private String endereco;
	private String telefone;
	
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	private String sexo;
	private String email;
	
	
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Integer getId() {
	      return id;
	   }

	
}
