package com.apex.repository;

import java.util.List;

import com.apex.pojo.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author ds035n
 *
 */
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

	
	public List<Appointment> findAll();
	
	List<Appointment> findByDescContaining(String desc);
	
	
	
	@SuppressWarnings("unchecked")
	public Appointment save(Appointment appointment);
	

}
