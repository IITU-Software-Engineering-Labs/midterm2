package kz.iitu.midterm;

import org.springframework.boot.SpringApplication;

public class TestMidTermApplication {

    public static void main(String[] args) {
        SpringApplication.from(MidTermApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
