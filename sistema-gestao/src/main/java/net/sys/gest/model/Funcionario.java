package net.sys.gest.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="funcionario")
@SequenceGenerator(name="funcionario_id_seq", sequenceName = "funcionario_id_seq", initialValue = 1, allocationSize = 1)
public class Funcionario {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName = "id", nullable = false)
	private Empresa empresa;
	
	@Column(name="nome", length = 100, nullable = true)
	private String nome;
	
	@Column(name="cpf", length = 14, nullable = true)
	private String cpf;
	
	@Column(name="endereco", length = 150, nullable = true)
	private String endereco;
	
	@Column(name="telefone", length = 15, nullable = true)
	private String telefone;
	
	@Column(name="email", length = 100, nullable = true)
	private String email;
	
	@Column(name="salario", nullable = true)
	private double salario;
	
	@Column(name="data_emissao", nullable = true)
	private LocalDate dataEmissao;
	
	@Column(name="data_criacao", nullable = true)
	private LocalDateTime dataCriacao;
	
	@Column(name="data_modificacao", nullable = true)
	private LocalDateTime dataModificacao;

	public Long getId() {
		return id;
	}

	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
	
}
