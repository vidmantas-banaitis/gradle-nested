package lt.vban.sample.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SampleApp.class)
class SampleAppTest {
    @Test
    void contextLoads() {
        // Test will fail if application context cannot start
        assertTrue(true);
    }
}