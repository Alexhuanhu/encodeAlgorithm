package com.abchina.encodeAlgorithm.model;

public class Algorithm {
	private String alg;	//�㷨����
	private String rult;	// ���㷨�����Ժ�Ľ��
	
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
