package addition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        // not needed : ApplicationContext ctx = 
        SpringApplication.run(Application.class, args);
    }

}
