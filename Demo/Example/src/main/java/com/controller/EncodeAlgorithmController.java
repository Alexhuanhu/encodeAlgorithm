package com.controller;

import com.model.Algorithm;
import com.service.AlgorithmService;
import com.util.FileDownloadTool;
import com.util.FileUtilsTool;
import com.util.RSAEncodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/login")
public class EncodeAlgorithmController {

	@Resource
	private AlgorithmService algorithmService;

	@RequestMapping(value = "/gotoRSAPage")
	public String gotoRSAPage() {

		return "/WEB-INF/pages/algorithms/RSA.jsp";
	}

	@RequestMapping(value = "/gotoReactPage")
	public String gotoReactPage() {

		return "/WEB-INF/pages/react/ReactTestPage.jsp";
	}

	/**
	 * 查找出数据库表中所有的记录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findAlgorithmResult")
	@ResponseBody
	public List<Algorithm> findAlgorithmResult(HttpServletRequest request, HttpServletResponse response) {
//		String inputString = request.getParameter("inputString");

		Algorithm algorithm = new Algorithm();
//		algorithm.setAlg("RSA");
//		algorithm.setRult(inputString);

		List<Algorithm> algorithmsList = this.algorithmService.findAlgorithm(algorithm);

		if (null == algorithmsList) {
			System.out.println("the query result is null, please check again!");
		}

		return algorithmsList;
	}

	/**
	 * SHA-1 加密算法
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/encodeSHA")
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
	 * 根据名称查找算法
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findAlgByName")
	@ResponseBody
	public List<Algorithm> findAlgorithmByName(HttpServletRequest request, HttpServletResponse response) {
		String inputString = request.getParameter("inputString");

		Algorithm algorithm = new Algorithm();
		algorithm.setAlg(inputString);

		List<Algorithm> algorithmList = this.algorithmService.findAlgorithmByName(algorithm);

		return algorithmList;
	}

	/**
	 * 将数据库中的所有数据，制成Excel表格，并且下载该表格
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/downloadExcelFile")
	public String downloadExcelFile(HttpServletRequest request, HttpServletResponse response) {

		// 查找出数据库中所有的数据
		List<Algorithm> algorithmList = this.algorithmService.findAlgorithm(new Algorithm());

		FileDownloadTool fileDownloadTool = new FileDownloadTool();

		// 下载Excel
		String downloadExcel = fileDownloadTool.createDownloadFileListXLS(request, response, algorithmList);

		if (null != downloadExcel) {
			// response
//			HttpServletResponse responseBak = ;

			FileUtilsTool fileUtilsTool = new FileUtilsTool();

			try {
				// 把传入的文件名改为 utf-8编码，解决中文乱码
				byte[] b = downloadExcel.getBytes("iso-8859-1");
				downloadExcel = new String(b, "utf-8");

				// 下载文件
//				fileUtilsTool.downloadFiles(response, );
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}


		return null;
	}





}
