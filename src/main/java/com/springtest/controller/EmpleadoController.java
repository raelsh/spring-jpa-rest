package com.springtest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtest.dao.EmpleadoDAO;
import com.springtest.model.Empleado;

@RestController
@RequestMapping("/company")
public class EmpleadoController {
	
	@Autowired
	EmpleadoDAO empDao;
	
	@PostMapping("/empleados")
	public Empleado crearEmpleado(@Valid @RequestBody Empleado emp) {
		return empDao.guardar(emp);
	}
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados(){
		return empDao.getEmpleados();
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> getEmpByID(@PathVariable(value = "id") Long id){
		Empleado emp=empDao.findOne(id);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> updateEmpleado(@PathVariable(value = "id") Long id,
													@Valid @RequestBody Empleado empDetalles){
		Empleado emp=empDao.findOne(id);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setNombre(empDetalles.getNombre());
		emp.setAsignacion(empDetalles.getAsignacion());
		emp.setHabilidad(empDetalles.getHabilidad());
		
		Empleado empActual= empDao.guardar(emp);
		return ResponseEntity.ok().body(empActual);
	}
	
	
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<Empleado> eliminaEmp(@PathVariable(value = "id") Long id){
		Empleado emp= empDao.findOne(id);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		empDao.eliminaEmp(emp);
		return ResponseEntity.ok().build();
	}
}
