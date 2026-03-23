package com.cg;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.controller.EmployeeController;
import com.cg.dto.EmployeeDTO;
import com.cg.service.IEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private IEmployeeService service;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void getEmployeeByIdApiTest() throws Exception {
		EmployeeDTO edto=new EmployeeDTO("Tusar",LocalDate.of(2001, 11, 12), 45000.0);
		when(service.getEmployee(1)).thenReturn(edto);
		
		mockMvc.perform(get("/api/employee/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.fullName").value("Tusar"))
		.andExpect(jsonPath("$.salary").value(45000));
	}
	
	@Test
	void getAllEmployeeTest() throws Exception {
		EmployeeDTO e1=new EmployeeDTO("Tusar",LocalDate.of(2001, 11, 12), 45000.0);
		EmployeeDTO e2=new EmployeeDTO("Samar",LocalDate.of(2002, 10, 15), 55000.0);
		EmployeeDTO e3=new EmployeeDTO("Jatin",LocalDate.of(1998, 10, 25), 35000.0);
		when(service.getAllEmployee()).thenReturn(List.of(e1,e2,e3));
		
		mockMvc.perform(get("/api/employee"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[2].fullName").value("Jatin"));
		
	}
	
	@Test
	void createEmployeeTest() throws Exception {
		EmployeeDTO e1=new EmployeeDTO("Saksham",LocalDate.of(2003, 11, 12), 45000.0);		
		when(service.createEmployee(any(EmployeeDTO.class))).thenReturn(e1);
		
		mockMvc.perform(post("/api/employee").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(e1))).andExpect(status().isOk())
		.andExpect(jsonPath("$.fullName").value("Saksham"));
		
		
		
	}
}
