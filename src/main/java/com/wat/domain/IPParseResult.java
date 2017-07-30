package com.wat.domain;

/**
 * 根据ip识别城市的返回结果 最外层
 * 
 * @author Wutao
 * @version 2017年7月26日 下午5:59:31
 * @see
 * @since
 */
public class IPParseResult {

	private String code;
	private IpInfo data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public IpInfo getData() {
		return data;
	}

	public void setData(IpInfo data) {
		this.data = data;
	}

	public IPParseResult(String code, IpInfo data) {
		super();
		this.code = code;
		this.data = data;
	}

	public IPParseResult() {
		super();
	}

}
