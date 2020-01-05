package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFound;
import com.cg.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	private TrainerService service;
	
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public Trainer getTrainerById(@PathVariable int id) throws TrainerNotFound {
		return service.fetchById(id);
	}
	
	@GetMapping(value = "/stream/{str}", produces = "application/json")
	public List<Trainer> getTrainersByStream(@PathVariable String str){
		return service.listTrainersByStream(str);
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<Trainer> listAll(){
		return service.listAllTrainers();
	}
	
	@GetMapping(value = "/searchbyfees/{min}/{max}", produces = "application/json")
	public List<Trainer> listByFees(@PathVariable double min, @PathVariable double max){
		return service.fetchTrainerByFees(min, max);
	}
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Trainer addTrainer(@RequestBody Trainer trainer) {
		return service.addNewTrainer(trainer);
	}
	
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public Trainer updateDetails(@RequestBody Trainer trainer) {
		return service.updateExistingTrainer(trainer);
	}
	
	@DeleteMapping(value = "/remove")
	public boolean removeTrainer(@RequestParam("id") int id) throws TrainerNotFound {
		return service.removeTrainer(id);
	}
	
}
