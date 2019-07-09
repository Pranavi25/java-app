package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TwitterCLIComponentscan {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(TwitterCLIComponentscan.class);
        TwitterCLIRunner runner = context.getBean(TwitterCLIRunner.class);
        runner.run(args);
    }
}
