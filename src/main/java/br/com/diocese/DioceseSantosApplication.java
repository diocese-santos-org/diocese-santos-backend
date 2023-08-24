package br.com.diocese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "br.com.diocese")
@EnableSwagger2
@EnableSpringDataWebSupport
@EnableCaching
public class DioceseSantosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioceseSantosApplication.class, args);
	}

}
