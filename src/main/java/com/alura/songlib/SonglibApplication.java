package com.alura.songlib;

import com.alura.songlib.main.MainApp;
import com.alura.songlib.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SonglibApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepository artistRepository;

	public static void main(String[] args) {
		SpringApplication.run(SonglibApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MainApp app = new MainApp(artistRepository);
		app.showMenu();
	}
}
