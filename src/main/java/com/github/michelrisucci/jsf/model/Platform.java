package com.github.michelrisucci.jsf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "platform")
public class Platform {

	private Long id;
	private String name;
	private String category;
	private Integer level;
	
	@Column(name="short_desc")
	private String shortDesc;
	@Column(name="long_desc")
	private String longDesc;
	public Platform(String name, String category, Integer level,
			String shortDesc, String longDesc) {
		super();
		this.name = name;
		this.category = category;
		this.level = level;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}
	public Platform() {
		super();
	}
	public Platform(String name) {
		super();
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	@Override
	public String toString() {
		return "Platform [id=" + id + ", name=" + name + ", category="
				+ category + ", level=" + level + ", shortDesc=" + shortDesc
				+ ", longDesc=" + longDesc + "]";
	}
	
	
}
