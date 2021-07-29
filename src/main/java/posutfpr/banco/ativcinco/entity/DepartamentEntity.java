package posutfpr.banco.ativcinco.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Departamento")
public class DepartamentEntity extends AbstractPersistable<Long> {

	@Column(name = "name", length = 64, nullable = true)
	private String name;

	public DepartamentEntity(String name) {
		super();
		this.name = name;
	}

	public DepartamentEntity() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}