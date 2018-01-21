package com.apex.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apex.pojo.Appointment;
import com.apex.service.AppointmentService;
import com.google.gson.Gson;

@Controller
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;
	
	

	
	
	@RequestMapping("/")
	public String test() {
		return "index";
	}
	
	@RequestMapping(value ="/addAppointment")
	public String addAppointment(HttpServletRequest request,Model model, Appointment appointment) {
		
		String msg = "";
		try {
			appointmentService.save(appointment);
		}catch(Exception e) {
			msg = "Error ";
		}
		model.addAttribute("message",msg);
		return "redirect:/";
	}
	
	@RequestMapping(value ="/getAppointments")
	public void getPosts(HttpServletRequest request,Model model,HttpServletResponse response,
			@RequestParam("toSelect") String desc){	
		
		List<Appointment> appointments = new ArrayList<>();
		try{ 
			if(desc.equals("")|| desc==null)
			appointments =appointmentService.findAll();	
			else
				appointments = appointmentService.findByDesc(desc);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try {
			String json =  "" ; 
			json =new Gson().toJson(appointments);
			response.getWriter().write("{ \"data\":"   + json + " }");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}