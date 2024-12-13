package kz.iitu.midterm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class MidTermApplicationTests {

    @Test
    void contextLoads() {
    }

}
