package br.com.ricardoludwig.springboot.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApplicationDemo {

	@RequestMapping(value = "/show/{name}")
	public String echoStudentName(@PathVariable(name = "name") String name) {
		return "Hello  " + name + " Responsed on : " + new Date();
	}

	@RequestMapping(value = "/showDetails/{name}")
	public Person getStudentDetails(@PathVariable(name = "name") String name) {
		return new Person(name, 40);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo.class, args);
	}
}

class Person {

	String name;
	int age;

	public Person(String $name, int $age) {
		name = $name;
		age = $age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
