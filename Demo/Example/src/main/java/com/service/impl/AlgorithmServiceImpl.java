package com.service.impl;

import com.dao.AlgorithmDao;
import com.model.Algorithm;
import com.service.AlgorithmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {
	
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
