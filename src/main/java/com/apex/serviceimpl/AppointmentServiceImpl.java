package com.apex.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apex.pojo.Appointment;
import com.apex.repository.AppointmentRepository;
import com.apex.service.AppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	
	@Autowired
	AppointmentRepository appointmentRepository;
	@Override
	public List<Appointment> findAll() {
		
		List<Appointment> appointments = new ArrayList<>();
		appointments = appointmentRepository.findAll();
		return appointments;
	}

	@Override
	public void save(Appointment appointment) {
		
		appointmentRepository.save(appointment);
		
	}

	@Override
	public List<Appointment> findByDesc(String desc) {
		List<Appointment> appointments = new ArrayList<>();
		appointments = appointmentRepository.findByDescContaining(desc);
		return appointments;
	}

}
