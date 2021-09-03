package com.yedam.app;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV implements TV{
	
	@Autowired Speaker speaker;
	
	public void turnon() {
		System.out.println("Samsung TV turnon");
	}
	
	public void turnoff() {
		System.out.println("Samsung TV turnoff");
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
