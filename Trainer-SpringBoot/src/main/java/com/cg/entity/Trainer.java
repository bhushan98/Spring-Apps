package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "traseq", sequenceName = "tra_seq", allocationSize = 1)
@NamedQuery(name = "allTrainers", query = "SELECT t FROM Trainer t")
@NamedQuery(name = "byStream", query = "SELECT t FROM Trainer t WHERE t.stream=:str")
@NamedQuery(name = "byFees", query = "SELECT t FROM Trainer t WHERE t.fees BETWEEN :min and :max")
public class Trainer {
	
	@Id
	@GeneratedValue(generator = "traseq")
	private int id;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String stream;
	private double fees;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
	
}
