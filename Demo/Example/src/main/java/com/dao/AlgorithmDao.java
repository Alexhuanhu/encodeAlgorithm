package com.dao;

import com.model.Algorithm;

import java.util.List;

public interface AlgorithmDao {
	
	// 查询所有的算法
	List<Algorithm> findAlgorithm(Algorithm algorithm);
	
	// 根据名称查找算法
	List<Algorithm> findAlgorithmByName(Algorithm algorithm);

}
