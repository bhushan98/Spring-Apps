package com.cg.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.TrainerDao;
import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFound;

@Service
@Transactional(rollbackFor = TrainerNotFound.class)
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	private TrainerDao dao;
	
	@Override
	public List<Trainer> listAllTrainers() {
		return dao.listAll();
	}

	@Override
	public List<Trainer> listTrainersByStream(String str) {
		return dao.listTrainerByStream(str);
	}

	@Override
	public Trainer addNewTrainer(Trainer trainer) {
		return dao.addTrainer(trainer);
	}

	@Override
	public Trainer updateExistingTrainer(Trainer trainer) {
		return dao.updateTrainerDetails(trainer);
	}

	@Override
	public Trainer fetchById(int id) throws TrainerNotFound {
		return dao.fetch(id);
	}

	@Override
	public boolean removeTrainer(int id) throws TrainerNotFound {
		return dao.deleteTrainer(id);
	}

	@Override
	public List<Trainer> fetchTrainerByFees(double min, double max) {
		return dao.fetchByFees(min, max);
	}

}
