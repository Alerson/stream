package com.stream.features;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(){
		return args -> {
			// Creating stream
			List<String> myList = Arrays.asList("apple", "banana", "cherry");
			Stream<String> myStream = myList.stream();

			System.out.println("Filter elements based on condition");
			myList.stream().filter(filter -> filter.startsWith("a")).forEach(System.out::println);

			System.out.println("Transform each element into another form using the Map function");
			myList.stream().map(String::toUpperCase).forEach(System.out::println);

			System.out.println("Sort elements");
			myList.stream().sorted().forEach(System.out::println);

			System.out.println("Collect elements into a collection or another form");
			List<String> filteredList = myList.stream().filter(filter -> filter.contains("a")).toList();
			System.out.println(filteredList);

			System.out.println("Used to check wheter a certain predicate matches the stream elements");
			boolean allMatch = myList.stream().allMatch(item -> item.startsWith("a"));
			System.out.println("allMatch -> " + allMatch);
			boolean anyMatch = myList.stream().anyMatch(item -> item.startsWith("a"));
			System.out.println("anyMatch -> " + anyMatch);
			boolean noneMatch = myList.stream().noneMatch(item -> item.startsWith("x"));
			System.out.println("noneMatch -> " + noneMatch);

			System.out.println("Return the count of element in the stream");
			long size = myList.stream().count();
			System.out.println(size);
			long containsB = myList.stream().filter(item -> item.contains("b")).count();
			System.out.println(containsB);

			System.out.println("Performs a reduce on the elements of the stream using an associative accumulation function");
			Optional<String> reduce = myList.stream().reduce((s1, s2) -> s1 + "#" + s2);
			reduce.ifPresent(System.out::println);
		};
	}

}
