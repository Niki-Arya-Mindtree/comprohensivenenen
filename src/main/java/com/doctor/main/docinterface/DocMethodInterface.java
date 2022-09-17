package com.doctor.main.docinterface;

import java.util.List;

import com.doctor.main.exception.EmptyData;
import com.doctor.main.model.Model;

public interface DocMethodInterface {
	public List<Model> getAll() throws EmptyData;
	public Model oneData(int Id) throws EmptyData;
	public void updateModel(Model md);
	public void oneSave(Model md);
}
