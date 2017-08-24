package com.abchina.encodeAlgorithm.service;

import java.util.List;

import com.abchina.encodeAlgorithm.model.Algorithm;

public interface AlgorithmService {
	
	// 查询所有的算法
	List<Algorithm> findAlgorithm(Algorithm algorithm);
	
	// 根据算法名称查询算法
	List<Algorithm> findAlgorithmByName(Algorithm algorithm);
}
