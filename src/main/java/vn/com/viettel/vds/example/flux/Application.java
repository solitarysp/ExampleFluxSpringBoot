package vn.com.viettel.vds.example.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(
        exclude = {WebMvcAutoConfiguration.class},
        scanBasePackages = {"vn.com.viettel.vds.example.flux"}
)
@EnableScheduling
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
