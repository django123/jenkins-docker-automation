package io.django.it.jenkinsdockerautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDockerAutomationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDockerAutomationApplication.class, args);
    }

    @GetMapping
    public String Home(){
        return "Hello World";
    }

}
