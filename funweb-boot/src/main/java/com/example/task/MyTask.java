package com.example.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.service.SampleService;

import lombok.extern.java.Log;

@Log
@Component
public class MyTask {
	
	@Autowired
	private SampleService sampleService;
	
	@Scheduled(fixedRate = 1000) // 1000*60*60*24 -> 24시간 주기로 반복실행
	public void schedule1() throws Exception {
		int result = sampleService.doAdd("20", "10");
		log.info("result : " + result);
		
		long now = System.currentTimeMillis() / 1000;
		log.info("스케줄링 작업 1 : 1초마다 실행 - " + now);
	}
	
	@Scheduled(fixedRate = 2000)
	public void schedule2() {
		long now = System.currentTimeMillis() / 1000;
		log.info("스케줄링 작업 2 : 2초마다 실행 - " + now);
	}
	
	@Scheduled(fixedRate = 3000)
	public void schedule3() {
		long now = System.currentTimeMillis() / 1000;
		log.info("스케줄링 작업 3 : 3초마다 실행 - " + now);
	}
	
	@Scheduled(cron = "0 * * * * *")
	public void schedule4() {
		long now = System.currentTimeMillis() / 1000;
		log.info("스케줄링 작업 4 : 매분 0초마다 실행 - " + now);
	}
	
}
