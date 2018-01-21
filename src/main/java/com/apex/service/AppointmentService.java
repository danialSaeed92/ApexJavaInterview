package com.apex.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.apex.pojo.Appointment;

@Service
public interface AppointmentService   {

	public List<Appointment> findAll();
	public List<Appointment> findByDesc(String desc);
	public void save(Appointment appointment);
	
	

	 
}
