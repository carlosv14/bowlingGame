package com.example.bowling;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BowlingApplication implements CommandLineRunner {

	private Game game;
	public BowlingApplication(Game game){
		this.game = game;
	}

	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);
	}

	@Override
	public void run(String... args) {
		this.game.start("C:\\temp\\game.txt");
		this.game.displayResults();
	}
}
