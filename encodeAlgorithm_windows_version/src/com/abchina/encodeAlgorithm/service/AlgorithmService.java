package com.abchina.encodeAlgorithm.service;

import java.util.List;

import com.abchina.encodeAlgorithm.model.Algorithm;

public interface AlgorithmService {
	
	// ��ѯ���е��㷨
	List<Algorithm> findAlgorithm(Algorithm algorithm);
	
	// �����㷨���Ʋ�ѯ�㷨
	List<Algorithm> findAlgorithmByName(Algorithm algorithm);
}
