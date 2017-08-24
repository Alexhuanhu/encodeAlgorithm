package com.abchina.encodeAlgorithm.model;

public class Algorithm {
	private String alg;	//算法名称
	private String rult;	// 用算法加密以后的结果
	
	public Algorithm() {
		super();
	}

	public Algorithm(String alg, String rult) {
		super();
		this.alg = alg;
		this.rult = rult;
	}

	public String getAlg() {
		return alg;
	}

	public void setAlg(String alg) {
		this.alg = alg;
	}

	public String getRult() {
		return rult;
	}

	public void setRult(String rult) {
		this.rult = rult;
	}

	@Override
	public String toString() {
		return "Algorithm [alg=" + alg + ", rult=" + rult + "]";
	}
	
}
