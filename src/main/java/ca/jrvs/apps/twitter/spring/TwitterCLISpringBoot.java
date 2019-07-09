package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ca.jrvs.apps.twitter")
public class TwitterCLISpringBoot implements CommandLineRunner {

    private TwitterCLIRunner runner;

    @Override
    public void run(String... args) throws Exception {
        runner.run(args);
    }

    @Autowired
    public TwitterCLISpringBoot(TwitterCLIRunner runner){
        this.runner = runner;
    }

    public static void main(String[] args){
        SpringApplication application = new SpringApplication(TwitterCLISpringBoot.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
