package br.com.ricardoludwig.springboot.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class ApplicationDemo {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApplicationDemo.class).web(WebApplicationType.SERVLET).run(args);
	}
}

@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	/**
	 * Show own register instance at Eureka
	 * @param applicationName
	 * @return
	 */
	@RequestMapping("/show-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	@RequestMapping(value = "/show/{name}")
	public String echoStudentName(@PathVariable(name = "name") String name) {
		return "Hello  " + name + " Responsed on : " + new Date();
	}

	@RequestMapping(value = "/showAge/{name}")
	public Person getStudentDetails(@PathVariable(name = "name") String name) {
		return new Person(name, 40);
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
