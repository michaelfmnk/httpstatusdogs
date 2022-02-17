package dev.fomenko.httpstatusdogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@ComponentScan("dev.fomenko.httpstatusdogs.config")
public class FakeControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FakeControllerApplication.class);
    }

    @RestController
    static class FakeController {
        @GetMapping("/200")
        public String method200() {
            return "fake!";
        }

        @GetMapping("/404")
        public String method404(HttpServletResponse response) {
            response.setStatus(404);
            return "fake!";
        }
    }
}
