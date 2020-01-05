package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.emtity.Laptop;
import com.cg.repo.LaptopRepo;

@Service
@Transactional
public class LaptopServiceImpl implements LaptopService {

	@Autowired
	private LaptopRepo repo;
	
	@Override
	public Laptop add(Laptop laptop) {
		return repo.save(laptop);
	}

	@Override
	public List<Laptop> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Laptop update(Laptop laptop) {
		return repo.save(laptop);
	}

	@Override
	public Boolean delete(int id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public Laptop fetchById(int id) {
		return repo.findById(id).get();
	}

}
