package br.com.agendex.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
public class Paciente extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paciente_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "paciente_seq", sequenceName = "paciente_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@NotEmpty(message = "Informe o nome.", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false)
	@Length(min = 0, max = 255, message = "O limite do campo nome do paciente é de 255 caracteres.", groups = AmbientValidator.class)
	private String nome;

	@NotEmpty(message = "Informe a nome social.", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false)
	@Length(min = 0, max = 255, message = "O limite do nome social do paciente é de 255 caracteres.", groups = AmbientValidator.class)
	private String nomeSocial;

	@NotEmpty(message = "Informe o CPF.", groups = AmbientValidator.class)
	@Column(length = 15, nullable = false, unique = true)
	@Length(min = 11, max = 14, message = "O limite do campo CPF do paciente é de 11 caracteres.", groups = AmbientValidator.class)
	private String cpf;

	@NotEmpty(message = "Informe o RG.", groups = AmbientValidator.class)
	@Column(length = 7, nullable = false, unique = true)
	@Length(min = 7, max = 7, message = "O limite do campo RG do paciente é de 7 caracteres.", groups = AmbientValidator.class)
	private String rg;

	@NotEmpty(message = "Informe o telefone.", groups = AmbientValidator.class)
	@Column(length = 15, unique = true)
	@Length(min = 0, max = 15, message = "O limite do campo telefone do paciente é de 15 caracteres.", groups = AmbientValidator.class)
	private String telefone;

	@NotEmpty(message = "Informe o e-mail.", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false, unique = true)
	@Length(min = 0, max = 255, message = "O limite do campo e-mail do paciente é de 255 caracteres.", groups = AmbientValidator.class)
	private String email;

	@NotEmpty(message = "Informe o Orgão Expeditor.", groups = AmbientValidator.class)
	@Column(length = 50, nullable = false)
	@Length(min = 0, max = 50, message = "O limite do campo orgão expeditor do registro geral é de 50 caracteres.", groups = AmbientValidator.class)
	private String orgaoExpeditor;

	@NotEmpty(message = "Informe o Sexo.", groups = AmbientValidator.class)
	@Column(length = 20, nullable = false)
	@Length(min = 0, max = 20, message = "O limite do campo sexo é de 20 caracteres.", groups = AmbientValidator.class)
	private String sexo;

	@NotEmpty(message = "Informe a Data de nascimento.", groups = AmbientValidator.class)
	@Column(length = 10)
	@Length(min = 0, max = 10, message = "O limite do campo data de nascimento é de 10 caracteres.", groups = AmbientValidator.class)
	private String dataNascimento;


	Usuario usuario;
	
	
	@Override
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



}
