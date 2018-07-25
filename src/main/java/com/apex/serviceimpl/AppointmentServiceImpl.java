package com.apex.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apex.pojo.Appointment;
import com.apex.repository.AppointmentRepository;
import com.apex.service.AppointmentService;
/**
 * 
 * @author ds035n
 *
 */
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	
	@Autowired
	AppointmentRepository appointmentRepository;
	@Override
	public List<Appointment> findAll() {
		
		return appointmentRepository.findAll();
		 
	}

	@Override
	public void save(Appointment appointment) {
		
		appointmentRepository.save(appointment);
		
	}

	@Override
	public List<Appointment> findByDesc(String desc) {
	
		return appointmentRepository.findByDescContaining(desc);
	}

}
