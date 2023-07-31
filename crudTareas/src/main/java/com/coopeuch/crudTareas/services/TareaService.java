package com.coopeuch.crudTareas.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coopeuch.crudTareas.models.TareaModel;
import com.coopeuch.crudTareas.repositories.ITareaRepository;

@Service
public class TareaService {

	@Autowired
	ITareaRepository tareaRepository;
	
	public ArrayList<TareaModel> getTareas(){
		return (ArrayList<TareaModel>) tareaRepository.findAll();
	}
	
	public TareaModel saveTarea(TareaModel tareaModel){
		return tareaRepository.save(tareaModel);
	}
	
	public TareaModel updateTareaById(TareaModel request, Long id){
		TareaModel tareaModel = tareaRepository.findById(id).get();
		tareaModel.setIdTarea(request.getIdTarea());
		tareaModel.setNombreTarea(request.getNombreTarea());
		tareaModel.setDescripcionTarea(request.getDescripcionTarea());
		tareaRepository.save(tareaModel);
		return tareaModel;
	}
	
	public Boolean deleteTareaById(Long id){
		try {
			System.out.println("Ejecutando delete Services.");
			tareaRepository.deleteById(id);
			System.out.println("Despues de ejecutar delete Services.");
			return true;
		} catch (Exception e) {
			System.out.println("Exceptions en delete Services.");
			return false;
		}
	}
}
