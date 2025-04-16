package net.sys.gest.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="usuario")
@SequenceGenerator(name="usuario_id_seq", sequenceName = "usuario_id_seq", initialValue = 1, allocationSize = 1)
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
	private Long id;
	
	@Column(name="nome", length = 100)
	private String nome;
	
	@Column(name="cpf", length = 16)
	private String cpf;
	
	@Column(name="login", length = 100, unique = true, nullable = false)
	private String login;
	
	@Column(name="senha", length = 255, nullable = false)
	private String senha;
	
	@Column(name="data_atual_senha")
	private LocalDate dataAtualSenha;
	
	@Column(name="data_criacao")
	private LocalDateTime dataCriacao;
	
	@Column(name="data_modificacao")
	private LocalDateTime dataModificacao;
	
	@Column(name="status")
	private boolean status = false;
	
	

	@OneToMany(fetch = FetchType.LAZY) // vai carregar os acessos apenas quando precisar.
	@JoinTable(name="usuarios_acesso", 
	uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "acesso_id"}, 
	name="unique_acesso_user"),
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false),foreignKey = @ForeignKey(name="usuario_fk", value = ConstraintMode.CONSTRAINT), 
	inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false,  referencedColumnName = "id", table = "acesso", foreignKey=@ForeignKey(name="acesso_fk", value = ConstraintMode.CONSTRAINT)) )
	private List<Acesso> acessos;
	

	// Autoridades = São os acessos, ou seja, ROLE_ADMIN, ROLE_SECRETARIO, ROLE_FINANCEIRO
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 
		return this.acessos;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDataAtualSenha() {
		return dataAtualSenha;
	}

	public void setDataAtualSenha(LocalDate dataAtualSenha) {
		this.dataAtualSenha = dataAtualSenha;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
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

	@Override
	public boolean isAccountNonExpired() {
		 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	 
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	 
		return true;
	}

	@Override
	public boolean isEnabled() {
	 
		return true;
	}
}
