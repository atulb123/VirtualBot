package com.test.utility;

import java.io.FileReader;
import java.util.Arrays;

import com.google.gson.Gson;
import com.test.model.DeviceCapabilityModel;

public class GetMobileCapability {
	public DeviceCapabilityModel getCapability(String userType) {
		try {
			return Arrays
					.asList(new Gson().fromJson(
							new FileReader(System.getProperty("user.dir")
									+ "/src/test/resources/config/DeviceCapabilities.json"),
							DeviceCapabilityModel[].class))
					.stream().filter(mobileCapability -> mobileCapability.getDeviceType().equals(userType)).findFirst().get();
		} catch (Exception e) {
			System.out.println("Mobile Capability File not found");
			e.printStackTrace();
			return null;
		}

	}
}
