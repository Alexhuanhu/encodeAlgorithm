package com.abchina.encodeAlgorithm.dao;

import java.util.List;

import com.abchina.encodeAlgorithm.model.Algorithm;

public interface AlgorithmDao {
	
	// ��ѯ���е��㷨
	List<Algorithm> findAlgorithm(Algorithm algorithm);
	
	// ���㷨���Ʋ�ѯ���
	List<Algorithm> findAlgorithmByName(Algorithm algorithm);

}
