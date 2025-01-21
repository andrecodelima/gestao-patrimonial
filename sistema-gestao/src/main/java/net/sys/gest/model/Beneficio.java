package net.sys.gest.model;

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
@Table(name="beneficio")
@SequenceGenerator(name="beneficio_id_seq", sequenceName = "beneficio_id_seq", initialValue = 1, allocationSize = 1)
public class Beneficio {


	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beneficio_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_funcionario", referencedColumnName = "id", nullable = false)
	private Funcionario funcionario;
	
	@Column(name="nome", length = 100, nullable = true)
	private String nome;
	
	@Column(name="tipo", length = 100, nullable = true)
	private String tipo;
	
	@Column(name="descricao", length = 100, nullable = true)
	private String descricao;
	
	@Column(name="valor", nullable = true)
	private double valor;
	
	@Column(name="data_criacao", nullable = true)
	private LocalDateTime dataCriacao;

	@Column(name="data_modificacao", nullable = true)
	private LocalDateTime dataModificacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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
		Beneficio other = (Beneficio) obj;
		return Objects.equals(id, other.id);
	}
	
}
