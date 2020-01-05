package com.cg.service;

import java.util.List;

import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFound;

public interface TrainerService {
	
	List<Trainer> listAllTrainers();
	
	List<Trainer> listTrainersByStream(String str);
	
	Trainer addNewTrainer(Trainer trainer);
	
	Trainer updateExistingTrainer(Trainer trainer);
	
	Trainer fetchById(int id) throws TrainerNotFound;
	
	boolean removeTrainer(int id) throws TrainerNotFound;
	
	List<Trainer> fetchTrainerByFees(double min, double max);
}
