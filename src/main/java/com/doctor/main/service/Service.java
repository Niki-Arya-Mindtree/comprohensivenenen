package com.doctor.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doctor.main.docinterface.DocMethodInterface;
import com.doctor.main.exception.EmptyData;
import com.doctor.main.model.Model;
import com.doctor.main.repos.DoctorRepos;

@org.springframework.stereotype.Service
public class Service implements DocMethodInterface{

	@Autowired
	private DoctorRepos repos;
	
	/* The Below Method Extracts all Data from the DoctorDatabse */
	@Override
	public List<Model> getAll() throws EmptyData
	{
		if(repos.findAll().size()==0)
			throw new EmptyData("Empty Data Base");
		return repos.findAll();
	}

	/* The Below Method takes in Id (integer) Extracts one Doctor Details from DoctorDatabase */
	@Override
	public Model oneData(int Id) throws EmptyData
	{
		if(repos.findById(Id).isEmpty())
			throw new EmptyData("Wrong Id");
		return repos.findById(Id).get();
	}

	
	/* The Below Method takes in one Complete Doctor Details and update the values by using its Id */
	@Override
	public void updateModel(Model md) 
	{
		if(repos.findById(md.getId()).isPresent())
		{System.out.println("hello");}
		Model tempmd = repos.findById(md.getId()).get();
		tempmd.setName(md.getName());
		tempmd.setSalary(md.getSalary());
		tempmd.setSpecialist(md.getSpecialist());
		repos.saveAndFlush(tempmd);	
		
		
		
		
	}
	
	
	public void updateModel(int Id , int Sal) 
	{		
		if(repos.findById(Id).isEmpty())
		{}
		Model tempmd = repos.findById(Id).get();
		tempmd.setSalary(Sal);
		repos.save(tempmd);
	}

	/* The Below Method takes in one Complete Doctor Details and add its to the DoctorDatabase */
	@Override
	public void oneSave(Model md) 
	{repos.saveAndFlush(md);}
	
	/* The Below Method takes in List of all the Data of Doctor in and return the sorted list in salary */
	public List<Model> nameWise()
	{return new DescSalary().docSortSalary(repos.findAll());}
	
	
	
	
	

}
