package com.shailahir.apps.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import java.util.TimeZone;

@SpringBootApplication
public class MyBlogApplication {

	public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication application = new SpringApplication(MyBlogApplication.class);

        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
	}

}
