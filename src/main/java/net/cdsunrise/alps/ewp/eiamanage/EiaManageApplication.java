package net.cdsunrise.alps.ewp.eiamanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("net.cdsunrise.alps.ewp.eiamanage.repository")
public class EiaManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EiaManageApplication.class, args);
    }
}
