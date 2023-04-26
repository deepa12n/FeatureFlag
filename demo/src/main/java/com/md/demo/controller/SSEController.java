package com.md.demo.controller;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.md.demo.service.SSEService;
import com.md.demo.vo.PublishData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/sseApi")
public class SSEController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SSEController.class);
	
	@Autowired
	SSEService SseService;
	
	
	
	//Publisher with live Flag Updates as input ,method will create an event and this event will be published to the clients via SSE events.
	//Whenever there is change in DB, with insertion/updates this endpoint should be called to publish  
	@PostMapping("/flagUpdates")
	public Mono<PublishData> publishFeatureFlagChanges(@RequestBody PublishData fd) {
		LOGGER.info("Received '{}'", fd);
		SseService.publish(fd);
		return Mono.just(fd);
		
	}
	
	
	//Client calls  Get request , for the real-time/live  update to the connected clients.They subscribe for the publishData updates
	@GetMapping(path = "/flagUpdates/{clientId}/{projectId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Object>> streamEvents(@PathVariable("clientId") String clientId,@PathVariable("projectId") String projectId) {
		
		return Flux.create(sink -> SseService.subscribe(sink::next, clientId, projectId)).map(
				publishData -> ServerSentEvent.builder()
                .id("id").event("Update")
                .data(publishData).comment("Flag data was updated")
                .retry(Duration.ofMillis(300)) 
                .build());
		
		
	}
}


//published data should be identified as it belongs to a particular project - Done 
//consumers/subscribers should also pass projectId as parameter to identify which project it should read - Done
//Consumers/subscribers should be identifiable with client id to differentiate each client service,(sub id to identify pod- PENDING) - Done
//Publisher should push data to queue and listeners should subscribe to a queue with projectName as params 
//Consumers/subscribers should be identifiable with session id to log each time client reconnect / offline, which will be stored in redis

