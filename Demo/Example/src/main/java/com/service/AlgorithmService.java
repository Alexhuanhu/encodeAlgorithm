package com.service;

import com.model.Algorithm;

import java.util.List;

public interface AlgorithmService {
	
	// 查找所有算法
	List<Algorithm> findAlgorithm(Algorithm algorithm);
	
	// 根据名称查找所有的算法
	List<Algorithm> findAlgorithmByName(Algorithm algorithm);
}
