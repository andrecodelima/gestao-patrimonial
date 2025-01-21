package net.sys.gest.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="acesso")
@SequenceGenerator(name="acesso_id_seq", sequenceName = "acesso_id_seq", initialValue = 1, allocationSize = 1)
public class Acesso implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acesso_id_seq")
	private long id;
	
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@Column(name="data_criacao")
	private LocalDateTime dataCriacao;
	
	@Column(name="data_modificacao")
	private LocalDateTime dataModificacao;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acesso other = (Acesso) obj;
		return id == other.id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String getAuthority() {
		 
		return this.descricao;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public LocalDateTime getDataModificacao() {
		return dataModificacao;
	}


	public void setDataModificacao(LocalDateTime dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	
}
