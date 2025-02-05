package com.sample.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	private String message = "Hello, Welcome!";
    private int number = 10;
    private double price = 99.99;

    @GetMapping("/variables")
    public String getVariables() {
        // Creating an object of the class to access instance variables
        SampleController obj = new SampleController();

        // Accessing variables using the object
        String response = "Message: " + obj.message + ", Number: " + obj.number + ", Price: $" + obj.price;
        System.out.println(response); 
        return response;
    }

	    @GetMapping("/hello/{count}")
	    public String sayHello(@PathVariable("count") int count) {
	        StringBuilder response = new StringBuilder();

	        for (int i = 1; i <= count; i++) {
	            String message = "Hello, how are you? " + i;
	            System.out.println(message);  // Prints to the console
	            response.append(message).append("<br>"); // Appends message with line break for better readability
	        }

	        return response.toString(); // Returns the string multiple times in the response
	    }
	    
	   
	   
	    @GetMapping("/hello/{count}/{count1}")
	    public List<String> Hello(@PathVariable("count") int count, @PathVariable("count1") int count1) {
	        List<String> messages = new ArrayList<>();
	        count1=count+4;

	        for (int i = 0; i <= count1; ++i) {
	            String message = "Hello, how are you? " + i;
	            System.out.println(message); 
	            messages.add(message); 
	        }

	        return messages; 
	    }
	    @GetMapping("/numbers/{count}")
	    public List<Integer> getNumbers(@PathVariable int count) {
	        List<Integer> numbers = new ArrayList<>();
	        
	        for (int i = 1; i <= count; i++) {
	        	if (i % 3 == 0) {  // Only add even numbers
	                numbers.add(i);
	            }
	            
	           }
	        numbers.remove(8);
	        numbers.add(8,27);
	        //Collections.sort(numbers, Collections.reverseOrder());
	        Collections.reverse(numbers);
	        
	        	       
	        System.out.println(numbers);
	        return numbers; 
	    }

	    }

	

