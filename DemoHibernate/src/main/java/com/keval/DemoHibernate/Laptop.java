package com.keval.DemoHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Laptop")
public class Laptop {
	@Id
	private int lid;
	private String Lname;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "laptops")
	//	@ManyToMany(mappedBy = "laptops")
	private List<Student> students = new ArrayList<>();


	public List<Student> getStudent() {
		return students;
	}
	public void setStudent(List<Student> student) {
		this.students = student;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}



}
