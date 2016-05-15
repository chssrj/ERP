package br.com.erp.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="funcionario")
public class Funcionario {
	
	@Id
	@SequenceGenerator(name="funcionario_seq",sequenceName="funcionario_seq",allocationSize=1,initialValue=1)
	@GeneratedValue(generator="funcionario_seq",strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cargo")
	private Cargo cargo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_departamento")
	private Departamento departamento;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="numero_nis")
	private String numeroNis;
	
	@Column(name="numero_cpts")
	private Integer numeroCPTS;
	
	@Column(name="serie_cpts")
	private Integer serieCTPS;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_emissao_ctps")
	private Calendar dataEmissaoCTPS;
	
	@Column(name="data_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="data_admissao")
	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;
	
	@Column(name="data_demissao")
	@Temporal(TemporalType.DATE)
	private Calendar dataDemissao;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((dataDemissao == null) ? 0 : dataDemissao.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroNis == null) ? 0 : numeroNis.hashCode());
		return result;
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
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (dataDemissao == null) {
			if (other.dataDemissao != null)
				return false;
		} else if (!dataDemissao.equals(other.dataDemissao))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroNis == null) {
			if (other.numeroNis != null)
				return false;
		} else if (!numeroNis.equals(other.numeroNis))
			return false;
		return true;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroNis() {
		return numeroNis;
	}

	public void setNumeroNis(String numeroNis) {
		this.numeroNis = numeroNis;
	}

	public Calendar getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Calendar dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Long getId() {
		return id;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Integer getNumeroCPTS() {
		return numeroCPTS;
	}

	public void setNumeroCPTS(Integer numeroCPTS) {
		this.numeroCPTS = numeroCPTS;
	}

	public Integer getSerieCTPS() {
		return serieCTPS;
	}

	public void setSerieCTPS(Integer serieCTPS) {
		this.serieCTPS = serieCTPS;
	}

	public Calendar getDataEmissaoCTPS() {
		return dataEmissaoCTPS;
	}

	public void setDataEmissaoCTPS(Calendar dataEmissaoCTPS) {
		this.dataEmissaoCTPS = dataEmissaoCTPS;
	}
	
	

}
