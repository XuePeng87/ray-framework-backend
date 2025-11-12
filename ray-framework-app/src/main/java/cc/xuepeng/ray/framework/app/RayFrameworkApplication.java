package cc.xuepeng.ray.framework.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cc.xuepeng.ray.framework.*")
public class RayFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RayFrameworkApplication.class);
        application.setAllowCircularReferences(Boolean.TRUE);
        application.run(args);
    }

}
