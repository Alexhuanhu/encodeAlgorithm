package com.abchina.encodeAlgorithm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.abchina.encodeAlgorithm.dao.AlgorithmDao;
import com.abchina.encodeAlgorithm.model.Algorithm;

@Component
public class AlgorithmDaoImpl implements AlgorithmDao {
	
	private static final String NAMESPACE = "algorithm";
	
	@Resource
	private SqlSessionFactory sqlSessionFactoryAlgorithm;

	/**
	 * ��ѯ���ݿ������е��㷨
	 */
	@Override
	public List<Algorithm> findAlgorithm(Algorithm algorithm) {
		SqlSession sqlSession = sqlSessionFactoryAlgorithm.openSession();
		
		List<Algorithm> algorithmList = sqlSession.selectList(NAMESPACE + ".findAlgorithm", algorithm);
		
		sqlSession.close();
		
		return algorithmList;
	}
	
	/**
	 * �����㷨���Ʋ�ѯ�㷨
	 */
	@Override
	public List<Algorithm> findAlgorithmByName(Algorithm algorithm) {
		SqlSession sqlSession = sqlSessionFactoryAlgorithm.openSession();
		
		List<Algorithm> algorithmList = sqlSession.selectList(NAMESPACE + ".findAlgorithmByName", algorithm);
		
		sqlSession.close();
		
		return algorithmList;
	}

}
