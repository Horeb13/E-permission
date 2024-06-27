package ci.sndi.e_permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class EPermissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EPermissionApplication.class, args);
	}
	

}

	@RestController
	class HomeController {

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/test")
    public String test() {
        return "This is a test endpoint!";
    }
}
