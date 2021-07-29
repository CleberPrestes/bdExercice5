package posutfpr.banco.ativcinco.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Funcionario")
public class FuncEntity extends AbstractPersistable<Long> {

	@Column(name = "nome", length = 64, nullable = true)
	private String name;

	@Column(name = "qtdDependente", length = 64, nullable = true)
	private int dependents;

	@Column(name = "salario", length = 64, nullable = true)
	private Long pay;

	@Column(name = "cargo", length = 64, nullable = true)
	private String responsibility;

	
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private DepartamentEntity depart;

	public FuncEntity() {

	}

	public FuncEntity(String name, int dependents, Long pay, String responsibility, DepartamentEntity depart) {
		super();
		this.name = name;
		this.dependents = dependents;
		this.pay = pay;
		this.responsibility = responsibility;
		this.depart = depart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDependents() {
		return dependents;
	}

	public void setDependents(int dependents) {
		this.dependents = dependents;
	}

	public Long getPay() {
		return pay;
	}

	public void setPay(Long pay) {
		this.pay = pay;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public DepartamentEntity getDepart() {
		return depart;
	}

	public void setDepart(DepartamentEntity depart) {
		this.depart = depart;
	}

}