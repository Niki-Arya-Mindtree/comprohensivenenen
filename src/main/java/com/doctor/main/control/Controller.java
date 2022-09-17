package com.doctor.main.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.main.exception.EmptyData;
import com.doctor.main.model.Model;

@RestController
public class Controller {
	
	@Autowired
	private com.doctor.main.service.Service serv;
	
	@GetMapping("/doc-data")
	public ResponseEntity<Object> getFindAll()
	{
		try {
			return new ResponseEntity<>(serv.getAll() ,HttpStatus.FOUND);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		}
			
	}
	
	@GetMapping("/doc-data/{Id}")
	public ResponseEntity<Object> getOneData(@PathVariable int Id)
	{
		try {
			return new ResponseEntity<>(serv.oneData(Id) ,HttpStatus.FOUND);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		}
			
	}
	
	@PutMapping("/doc-data")
	public ResponseEntity<Object> getUpdateModel(@RequestBody Model mdd)
	{
		try {
			serv.updateModel(mdd);
			return new ResponseEntity<>(serv.oneData(mdd.getId()) ,HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			
	}
	
	@PutMapping("/doc-data/{Id}/{Sal}")
	public ResponseEntity<Object> getUpdateModel(@PathVariable int Id , @PathVariable int Sal)
	{
//		try {
//			serv.updateModel(mdd);
//			return new ResponseEntity<>(serv.oneData(mdd.getId()) ,HttpStatus.FOUND);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
		
		serv.updateModel(Id, Sal);
		return new ResponseEntity<>(serv.oneData(Id) ,HttpStatus.FOUND);
		
			
	}
	
	@PostMapping("/doc-data")
	public ResponseEntity<Object> getOneSaveModel(@RequestBody Model mdd)
	{
		try {
			serv.oneSave(mdd);
			return new ResponseEntity<>(HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			
	}
	
	
	@GetMapping("/doc-data/ascending")
	public ResponseEntity<Object> getNameWise()
	{
		try {
			return new ResponseEntity<>(serv.nameWise() ,HttpStatus.FOUND);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return new ResponseEntity<>("hey its an erro"+e.getMessage(),HttpStatus.NO_CONTENT);
		}
			
	}
}
