package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "flseq", sequenceName = "fl_seq")
@NamedQuery(name = "bycarrier", query = "from Flight where carrier = :car")
public class Flight {

	@Id
	@GeneratedValue(generator = "flseq")
	private int flid;
	@Column(length = 30)
	private String carrier;
	@Column(name = "kahase", length = 20)
	private String source;
	@Column(name = "kahatak", length = 20)
	private String destination;
	@Column(name = "fasla")
	private int distance;
	
	public int getFlid() {
		return flid;
	}
	public void setFlid(int flid) {
		this.flid = flid;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Flight [flid=" + flid + ", carrier=" + carrier + ", source=" + source + ", destination=" + destination
				+ ", distance=" + distance + "]";
	}
	
}
