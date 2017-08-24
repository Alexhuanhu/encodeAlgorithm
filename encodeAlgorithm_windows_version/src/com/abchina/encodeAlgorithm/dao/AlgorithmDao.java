package com.abchina.encodeAlgorithm.dao;

import java.util.List;

import com.abchina.encodeAlgorithm.model.Algorithm;

public interface AlgorithmDao {
	
	// 查询所有的算法
	List<Algorithm> findAlgorithm(Algorithm algorithm);
	
	// 按算法名称查询结果
	List<Algorithm> findAlgorithmByName(Algorithm algorithm);

}
