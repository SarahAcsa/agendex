package br.com.agendex.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Paciente {

   @Id
   @GeneratedValue(generator="paciente_seq", strategy=GenerationType.SEQUENCE)
   @SequenceGenerator(name="paciente_seq", sequenceName="paciente_seq", allocationSize=1, initialValue=1)
   private Integer id;
   
   private String nome;
   private String nomesocial; 
   private String cpf; 
   private String rg;
   private String telefone;
   private String nasc;
   private String sexo;
   private String email;
   private String endereco;
   private String orgaoexpeditor;
   
   
   public String getOrgaoexpeditor() {
	return orgaoexpeditor;
}

public void setOrgaoexpeditor(String orgaoexpeditor) {
	this.orgaoexpeditor = orgaoexpeditor;
}


   
   public String getRg() {
	return rg;
}

public void setRg(String rg) {
	this.rg = rg;
}
   
   public String getNomesocial() {
		return nomesocial;
	}

	public void setNomesocial(String nomesocial) {
		this.nomesocial = nomesocial;
	}	
   
   public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getNasc() {
	return nasc;
}

public void setNasc(String nasc) {
	this.nasc = nasc;
}

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getTelefone() {
      return telefone;
   }

   public void setTelefone(String telefone) {
      this.telefone = telefone;
   }

   public Integer getId() {
      return id;
   }
   
   public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}  

}
