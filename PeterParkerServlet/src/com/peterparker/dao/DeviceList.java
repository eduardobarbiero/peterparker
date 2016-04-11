package com.peterparker.dao;

import java.util.ArrayList;

import com.peterparker.models.Device;

public class DeviceList extends ArrayList<Device> implements EveryElementChecker {
	private static final long serialVersionUID = 1L;

	public boolean isEveryElementActive() {
		boolean every = false;
		
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i).getIsActive())
				every = true;
		}
		
		return every;
	}
}
