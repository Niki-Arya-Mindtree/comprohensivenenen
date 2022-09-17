package com.doctor.main.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.doctor.main.docinterface.DocAccSalary;
import com.doctor.main.model.Model;

public class DescSalary implements DocAccSalary , Comparator<Model>{

	@Override
	public List<Model> docSortSalary(List<Model> lmd) {
		Collections.sort(lmd,new DescSalary());
		sameName(lmd);
		return lmd;
	}
	
	public List<Model> sameName(List<Model> lnmd) {

		int valInd;
		for(int i=0;i<lnmd.size()-1;i++)
		{
			Model tempModel = new Model();
			Model tempModel2 = new Model();
			if(lnmd.get(i+1).getName().equals(lnmd.get(i).getName()))
			{
				if(lnmd.get(i+1).getSalary()>lnmd.get(i).getSalary())
				{
					tempModel = lnmd.get(i);
					tempModel2 = lnmd.get(i+1);
					lnmd.set(i+1, tempModel);
					lnmd.set(i, tempModel2);
				}
			}
		}
		
		return lnmd;
	}
	
	@Override
	public int compare(Model o1, Model o2) {
		if(o1.getName().equals(o2.getName()))
			return 0;
		else if(o1.getName().compareTo(o2.getName())<0)
			return 1;
		else
			return -1;
	}

}
