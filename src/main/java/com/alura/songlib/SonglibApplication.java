package com.alura.songlib;

import com.alura.songlib.main.MainApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SonglibApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SonglibApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MainApp app = new MainApp();
		app.showMenu();
	}
}
