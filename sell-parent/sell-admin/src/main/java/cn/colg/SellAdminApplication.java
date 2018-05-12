package cn.colg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot 启动类
 *
 * @author colg
 */
@MapperScan(basePackages = "cn.colg.mapper")
@SpringBootApplication
public class SellAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellAdminApplication.class, args);
	}
}
