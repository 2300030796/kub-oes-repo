package com.klef.sdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class OnlineExaminationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExaminationSystemApplication.class, args);
		System.out.println("Hi");
	}

}
