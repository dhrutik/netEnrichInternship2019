package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.Hashtable;

import java.util.Scanner;

@SpringBootApplication
@RestController

public class HelloAppEngine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(HelloAppEngine.class, args);
	}

	/*
	 * @GetMapping("/") public String hello() { return "Hello Spring Boot!"; }
	 * 
	 * @GetMapping("/Questions") public String helloSaurav(@RequestParam String s,
	 * Hashtable<Integer, String> table, String response) { table = new Hashtable
	 * <Integer, String>(); table.put(1, "How are you doing today?"); table.put(2,
	 * "What is the weather today"); if (table.contains(s)) { response = "Hi!"; }
	 * else if (table.contains(s)) { response =
	 * "It is sunny with a 2% chance of rain today."; } else { response =
	 * "I do not know how to answer your question. Please ask another one."; }
	 * return response; }
	 */
	/*
	 * @GetMapping("/Questions") public String questions(@RequestParam String s) {
	 * //Scanner scanner = new Scanner(System.in); if
	 * (s.equals("What is the weather today?")) { return
	 * "The weather today is sunny with a small chance of rain."; } else if
	 * (s.equals("How are you doing today?")) { return
	 * "I am doing great today. How about you?"; } return
	 * "Sorry, I cannot understand the question you are asking. Please ask again.";
	 * }
	 */
	@GetMapping("/Questions")
	public String advancedQuestions(@RequestParam String s) {
		String[] responses = new String[3];
		responses[0] = "The weather this week is sunny with a small chance of rain.";
		responses[1] = "I am doing great today. How about you?";
		responses[2] = "I don't know how to answer your question. Please ask again";
		for (int i = 0; i < responses.length - 1; i++) {
			if (s.contains("weather")) {
				return responses[0];
			} else if (s.contains("doing")) {
				return responses[1];
			}
		}
		return responses[2];
	}

	@GetMapping("/advice")
	public String advice(@RequestParam String s) {
		String[] responses = new String[5];
		responses[0] = "I can give you advice on friendship, relationships, and work. Which one would you like?";
		responses[1] = "The best advice I can give you is to remove distractions from your workspace.";
		responses[2] = "Be true to them, don't backstab them, don't talk behind their back.";
		responses[3] = "Once you start laughing, you start healing.";
		responses[4] = "I don't understand your question. Please ask again.";
		for (int i = 0; i < responses.length - 1; i++) {
			if (s.contains("advice") && !(s.contains("work") && s.contains("relationship") && s.contains("work"))) {
				return responses[0];
			} else if (s.contains("work")) {
				return responses[1];
			} else if (s.contains("relationship")) {
				return responses[2];
			} else if (s.contains("friend")) {
				return responses[3];
			}
		}
		return responses[4];
	}
}
