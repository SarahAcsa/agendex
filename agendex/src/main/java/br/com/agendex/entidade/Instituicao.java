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
public class Instituicao extends Entidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="instituicao_seq", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="instituicao_seq", sequenceName="instituicao_seq", allocationSize=1, initialValue=1)
    private Integer id;

    @NotEmpty(message="Informe o nome fantasia da instituição.", groups=AmbientValidator.class)
    @Column(length=255, nullable=false)
    @Length(min=0, max=255, message="O limite do campo nome social da instituição é de 255 caracteres.", groups=AmbientValidator.class)
    private String nome;
    
    @NotEmpty(message="Informe a razão social.", groups=AmbientValidator.class)
    @Column(length=255, nullable=false)
    @Length(min=0, max=255, message="O limite da razão social da instituição é de 255 caracteres.", groups=AmbientValidator.class)
    private String razaoSocial;

    @NotEmpty(message="Informe o CNPJ da instituição.", groups=AmbientValidator.class)
    @Column(length=255, nullable=false, unique=true)
    @Length(min=0, max=255, message="O limite do campo CNPJ da instituição é de 255 caracteres.", groups=AmbientValidator.class)
    private String cnpj;
    
    @NotEmpty(message="Informe o telefone.", groups=AmbientValidator.class)
    @Column(length=255, nullable=false, unique=true)
    @Length(min=0, max=255, message="O limite do campo telefone da instituição é de 255 caracteres.", groups=AmbientValidator.class)
    private String fone;
    
    @NotEmpty(message="Informe a inscrição estadual da instituição.", groups=AmbientValidator.class)
    @Column(length=255, nullable=false, unique=true)
    @Length(min=0, max=255, message="O limite do campo inscrição estadual da instituição é de 255 caracteres.", groups=AmbientValidator.class)
    private String inscricaoEstadual;
    
    @NotEmpty(message="Informe a inscrição municipal da instituição.", groups=AmbientValidator.class)
    @Column(length=255, nullable=false, unique=true)
    @Length(min=0, max=255, message="O limite do campo inscrição municipal da instituição é de 255 caracteres.", groups=AmbientValidator.class)
    private String inscricaoMunicipal;
    
    @NotEmpty(message="Informe o endereço da instituição.", groups=AmbientValidator.class)
    @Column(length=255)
    @Length(min=0, max=255, message="O limite do campo endereço da instituição é de 255 caracteres.", groups=AmbientValidator.class)
    private String endereco;

    @Override
    public Integer getId() {
        return id;
    }

    public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
