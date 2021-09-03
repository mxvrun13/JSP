package com.yedam.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 둘 중 하나만
public class SonyTV implements TV {
	
	@Autowired Speaker speaker;
	
	@Override
	public void turnon() {
		System.out.println("Sony TV turnon");
	}
	
	@Override
	public void turnoff() {
		System.out.println("Sony TV turnoff");
	}

	@Override
	public void volumnUp() {
		speaker.volumnUp();
	}

	@Override
	public void volumnDown() {
		speaker.volumnDown();
	}
	
}
