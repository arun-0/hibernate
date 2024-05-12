package com.keval.DemoHibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "rollno", nullable = false)
	private int rollno;

	@Column(name = "name", nullable = true, length = 255)
	private String name;

	@Column(name = "marks", nullable = true)
	private int marks;

//	@ManyToMany
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_laptop",
			joinColumns = {
				@JoinColumn(name = "studentid", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
				@JoinColumn(name = "laptopid", nullable = false, updatable = false)
			}
	)
//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(
//			name = "Student_Laptop", // Specify the name of the join table
//			joinColumns = @JoinColumn(name = "student_rollno"), // Column in the join table referencing Student
//			inverseJoinColumns = @JoinColumn(name = "laptop_lid") // Column in the join table referencing Laptop
//	)
	private List<Laptop> laptops = new ArrayList<>();

	public List<Laptop> getLaptop() {
		return laptops;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptops = laptop;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}




}
