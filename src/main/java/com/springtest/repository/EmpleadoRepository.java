package com.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtest.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
