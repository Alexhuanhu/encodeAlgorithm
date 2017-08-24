package com.abchina.encodeAlgorithm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abchina.encodeAlgorithm.dao.AlgorithmDao;
import com.abchina.encodeAlgorithm.model.Algorithm;
import com.abchina.encodeAlgorithm.service.AlgorithmService;

@Service
public class AlgorithmServiceImpl implements AlgorithmService  {
	
	@Resource
	private AlgorithmDao algorithmDao;
	
	@Override
	public List<Algorithm> findAlgorithm(Algorithm algorithm) {
		
		List<Algorithm> algorithmList = this.algorithmDao.findAlgorithm(algorithm);
		
		return algorithmList;
	}
	
	@Override
	public List<Algorithm> findAlgorithmByName(Algorithm algorithm) {
		
		List<Algorithm> algorithmList = this.algorithmDao.findAlgorithmByName(algorithm);
		
		return algorithmList;
	}

}
