package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.example.websocket.MyTextWebSocketHandler;

@Configuration
@EnableWebSocket // 웹소켓 서버 기능 활성화하기
public class MyWebSocketConfig implements WebSocketConfigurer {
	
	@Autowired
	private MyTextWebSocketHandler webSocketHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// "/chatting"는 소켓연결을 위한 주소로서 http 연결이 아닌 ws 연결이 되야 함!
		registry.addHandler(webSocketHandler, "/chatting")
				.addInterceptors(new HttpSessionHandshakeInterceptor()) // HttpSession에 있는 attributes 값들을 WebSocketSession으로 복사해줌!
				.setAllowedOrigins("*");
		
		
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();

	    scheduler.setPoolSize(2);
	    scheduler.setThreadNamePrefix("scheduled-task-");
	    scheduler.setDaemon(true);

	    return scheduler;
	}

}
