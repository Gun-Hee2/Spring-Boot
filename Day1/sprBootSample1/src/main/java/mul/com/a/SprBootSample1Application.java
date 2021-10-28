package mul.com.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "mul.com.a")
public class SprBootSample1Application {

	public static void main(String[] args) {
		SpringApplication.run(SprBootSample1Application.class, args);
	}

}
