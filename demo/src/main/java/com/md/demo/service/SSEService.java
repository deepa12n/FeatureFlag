package com.md.demo.service;

import java.util.function.Consumer;

import com.md.demo.vo.PublishData;

public interface SSEService {
	public void publish(PublishData fd);

	public void subscribe(Consumer<PublishData> listener, String clientId,String projectId);
}
