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
	 * 查询数据库中所有的算法
	 */
	@Override
	public List<Algorithm> findAlgorithm(Algorithm algorithm) {
		SqlSession sqlSession = sqlSessionFactoryAlgorithm.openSession();
		
		List<Algorithm> algorithmList = sqlSession.selectList(NAMESPACE + ".findAlgorithm", algorithm);
		
		sqlSession.close();
		
		return algorithmList;
	}
	
	/**
	 * 根据算法名称查询算法
	 */
	@Override
	public List<Algorithm> findAlgorithmByName(Algorithm algorithm) {
		SqlSession sqlSession = sqlSessionFactoryAlgorithm.openSession();
		
		List<Algorithm> algorithmList = sqlSession.selectList(NAMESPACE + ".findAlgorithmByName", algorithm);
		
		sqlSession.close();
		
		return algorithmList;
	}

}
