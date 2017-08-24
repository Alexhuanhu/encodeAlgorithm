package com.abchina.encodeAlgorithm.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abchina.encodeAlgorithm.model.Algorithm;
import com.abchina.encodeAlgorithm.service.AlgorithmService;
import com.abchina.encodeAlgorithm.util.RSAEncodeUtil;

@Controller
@RequestMapping("/login")
public class EncodeAlgorithmController {
	
	@Resource
	private AlgorithmService algorithmService;
	
	@RequestMapping("/gotoRSAPage")
	public String gotoRSAPage() {
		return "/WEB-INF/pages/algorithms/RSA.jsp";
	}
	
	/**
	 * 查询数据库中所有的算法
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/findAlgorithmResult")
	@ResponseBody
	public List<Algorithm> findAllAlgorithms(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String inputString = request.getParameter("inputString");
			
		Algorithm algorithm = new Algorithm();
//		algorithm.setAlg("RSA");
//		algorithm.setRult(inputString);
		
		List<Algorithm> algorithmList = this.algorithmService.findAlgorithm(algorithm);
		
		return algorithmList;
	}
	
	/**
	 * SHA-1 加密
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/encodeSHA")
	@ResponseBody
	public String encodeAlgorithm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String outputData = "";
		
		try {
			String inputString = request.getParameter("inputString");
			
			byte[] inputData = inputString.getBytes();
			
			outputData = RSAEncodeUtil.encryptSHA(inputData);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return outputData;
	}
	
	/**
	 * 根据输入的算法名查找算法，支持模糊匹配
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/findAlgByName")
	@ResponseBody
	public List<Algorithm> findAlgorithmByName(HttpServletRequest request, HttpServletResponse response) {
		String inputString = request.getParameter("inputString");
		
		Algorithm algorithm = new Algorithm();
		algorithm.setAlg(inputString);
		
		List<Algorithm> algorithmList = this.algorithmService.findAlgorithmByName(algorithm);
		
		return algorithmList;
	}

}
