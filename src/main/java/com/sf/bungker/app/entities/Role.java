package com.sf.bungker.app.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="roles")
@Entity
public class Role  {
	
	

	public Role(int id, String name, String descripton, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.descripton = descripton;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String descripton;
	private Date created_at;
	private Date updated_at;
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
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
