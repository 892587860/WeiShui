package com.weishui.service;

import java.util.List;
import java.util.Map;

public interface HyTelemetryService {
	List<Map<String, String>> selectRemotePackets();
}
