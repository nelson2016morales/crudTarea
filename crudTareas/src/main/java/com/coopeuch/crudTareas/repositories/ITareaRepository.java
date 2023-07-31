package com.coopeuch.crudTareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coopeuch.crudTareas.models.TareaModel;

@Repository
public interface ITareaRepository extends JpaRepository<TareaModel, Long>{

}
