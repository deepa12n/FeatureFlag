package com.md.demo.service.Impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.md.demo.service.SSEService;
import com.md.demo.vo.PublishData;

@Service
public class SSEServiceImpl implements SSEService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SSEServiceImpl.class);
	private final List<Consumer<PublishData>> listeners = new CopyOnWriteArrayList<>(); //obtained from redis
	
	public void publish(PublishData fd) {
		listeners.forEach(listener -> listener.accept(fd));
		
	}
	
	public void subscribe(Consumer<PublishData> listener, String clientId,String projectId) {
		listeners.add(listener);
        LOGGER.info("Listener with ClientId:{} added,looking for changes in Project: {} ",clientId,projectId);
        LOGGER.info("Total consumers: {}",listeners.size());
        LOGGER.info("List of listeners: {}" ,listeners.toArray());
	}

	
}
