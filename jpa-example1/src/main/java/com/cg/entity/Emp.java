package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emp_table")
@Data
public class Emp {
	@Id
	private int empid;
	private String name;
	private String department;
}
