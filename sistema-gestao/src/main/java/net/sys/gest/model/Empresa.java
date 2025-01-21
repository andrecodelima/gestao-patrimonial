package net.sys.gest.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="empresa")
@SequenceGenerator(name="empresa_id_seq", sequenceName = "empresa_id_seq", initialValue = 1, allocationSize = 1)
public class Empresa {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_id_seq")
	private Long id;
	
	
	@Column(name="nome_fantasia", length = 150)
	private String nomeFantasia;
	
	@Column(name="razao_social", length = 150)
	private String razao_social;
	
	@Column(name="tipo_ativade", length = 100)
	private String tipoAtividade;
	
	@Column(name="data_fundacao")
	private LocalDate dataFundacao;
	
	@Column(name="cnpj", length = 20)
	private String cnpj;
	
	@Column(name="endereco", length = 150)
	private String endereco;
	
	@Column(name="telefone", length = 15)
	private String telefone;
	
	@Column(name="email", length = 100)
	private String email;
	
	@Column(name="foro", length = 100)
	private String foro;
	
	@Column(name="funesban", length = 100)
	private String funesban;
	
	@Column(name="data_criacao")
	private LocalDateTime dataCriacao;
	
	@Column(name="data_modificacao")
	private LocalDateTime dataModificao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
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

	public String getForo() {
		return foro;
	}

	public void setForo(String foro) {
		this.foro = foro;
	}

	public String getFunesban() {
		return funesban;
	}

	public void setFunesban(String funesban) {
		this.funesban = funesban;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataModificao() {
		return dataModificao;
	}

	public void setDataModificao(LocalDateTime dataModificao) {
		this.dataModificao = dataModificao;
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
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}
}
