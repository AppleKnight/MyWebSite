package com.wat.domain;

/**
 * 根据ip识别城市的结果
 * 
 * @author Wutao
 * @version 2017年7月26日 下午5:49:20
 * @see
 * @since
 */
public class IpInfo {
	private String area;
	private String area_id;
	private String city;
	private String city_id;
	private String country;
	private String country_id;
	private String county;
	private String county_id;
	private String ip;
	private String isp;
	private String region;
	private String region_id;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCounty_id() {
		return county_id;
	}

	public void setCounty_id(String county_id) {
		this.county_id = county_id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public IpInfo() {
		super();
	}

	public IpInfo(String area, String area_id, String city, String city_id,
			String country, String country_id, String county, String county_id,
			String ip, String isp, String region, String region_id) {
		super();
		this.area = area;
		this.area_id = area_id;
		this.city = city;
		this.city_id = city_id;
		this.country = country;
		this.country_id = country_id;
		this.county = county;
		this.county_id = county_id;
		this.ip = ip;
		this.isp = isp;
		this.region = region;
		this.region_id = region_id;
	}

	@Override
	public String toString() {
		return "IpInfo [area=" + area + ", area_id=" + area_id + ", city="
				+ city + ", city_id=" + city_id + ", country=" + country
				+ ", country_id=" + country_id + ", county=" + county
				+ ", county_id=" + county_id + ", ip=" + ip + ", isp=" + isp
				+ ", region=" + region + ", region_id=" + region_id + "]";
	}

}
