package com.test.model;

public class DeviceCapabilityModel {

	private String deviceType;
	private String deviceName;
	private String platformVersion;
	private String browserName;
	private String noReset;
	private String platformName;
	private String appiumVersion;

	public String getAppiumVersion() {
		return appiumVersion;
	}

	public void setAppiumVersion(String appiumVersion) {
		this.appiumVersion = appiumVersion;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getNoReset() {
		return noReset;
	}

	public void setNoReset(String noReset) {
		this.noReset = noReset;
	}
}
