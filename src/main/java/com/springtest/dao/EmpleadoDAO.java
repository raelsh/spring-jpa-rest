package com.springtest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtest.model.Empleado;
import com.springtest.repository.EmpleadoRepository;

@Service
public class EmpleadoDAO {
	
	@Autowired
	EmpleadoRepository empRepo;
	
	public Empleado guardar(Empleado emp) {
		return empRepo.save(emp);
	}
	
	public List<Empleado> getEmpleados(){
		return empRepo.findAll();
	}
	
	public Empleado findOne(Long empid) {
		 return empRepo.findById(empid).get();
	}
	
	public void eliminaEmp(Empleado emp) {
		empRepo.delete(emp);
	}
}
