package com.dao.impl;

import com.dao.AlgorithmDao;
import com.model.Algorithm;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AlgorithmDaoImpl implements AlgorithmDao {

//	private static final String NAMESPACE = "algorithm";
	private static final String NAMESPACE = "";

	@Resource
	private SqlSessionFactory sqlSessionFactoryAlgorithm;

	/**
	 * 查找所有的加密算法
	 * @param algorithm
	 * @return
	 */
	@Override
	public List<Algorithm> findAlgorithm(Algorithm algorithm) {
		SqlSession sqlSession = sqlSessionFactoryAlgorithm.openSession();
		
		List<Algorithm> algorithmList = sqlSession.selectList(NAMESPACE + ".findAlgorithm", algorithm);
		
		sqlSession.close();
		
		return algorithmList;
	}

	/**
	 * 通过名称，查找所有的算法
	 * @param algorithm
	 * @return
	 */
	@Override
	public List<Algorithm> findAlgorithmByName(Algorithm algorithm) {
		SqlSession sqlSession = sqlSessionFactoryAlgorithm.openSession();
		
		List<Algorithm> algorithmList = sqlSession.selectList(NAMESPACE + ".findAlgorithmByName", algorithm);
		
		sqlSession.close();
		
		return algorithmList;
	}

}
