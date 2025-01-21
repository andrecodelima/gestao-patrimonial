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
@Table(name="ausencia")
@SequenceGenerator(name="ausencia_id_seq", sequenceName = "ausencia_id_seq", initialValue = 1, allocationSize = 1)
public class Ausencia {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencia_id_seq" )
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_funcionario", referencedColumnName = "id", nullable = false)
	private Funcionario funcionario;
	
	@Column(name="tipo", length = 100)
	private String tipo;
	
	@Column(name="data_inicio")
	private LocalDate dataInicio;
	
	@Column(name="data_fim")
	private LocalDate dataFim;
	
	@Column(name="data_criacao")
	private LocalDateTime dataCriacao;
	
	@Column(name="data_modificacao")
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
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
		Ausencia other = (Ausencia) obj;
		return Objects.equals(id, other.id);
	}
	
}
