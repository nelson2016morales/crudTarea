package com.coopeuch.crudTareas.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coopeuch.crudTareas.models.TareaModel;
import com.coopeuch.crudTareas.services.TareaService;

@RestController
@RequestMapping("/api")
public class TareaControler {

	@Autowired
	TareaService tareaService;

	@GetMapping()
	public ArrayList<TareaModel> getTareas(){
		return this.tareaService.getTareas();
	}

	@PostMapping
	public TareaModel saveTarea(@RequestBody TareaModel tareaModel) {
		return this.tareaService.saveTarea(tareaModel);
	}

	@PutMapping(path = "/{id}")
	public TareaModel updateTareaById(@RequestBody TareaModel request ,@PathVariable("id") Long id){
		return this.tareaService.updateTareaById(request, id);
	}

	@DeleteMapping(path = "/{id}")
	public String deleteTareaById(@PathVariable("id") Long id) {
		if (tareaService.deleteTareaById(id))
			return "Borrado OK";
		else
			return "No Borrado";
	}	
}
