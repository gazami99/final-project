package encore.io.playdata.sub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	public Controller() {
		System.out.println("Controller 생성자 ---------");
	}
	
	@GetMapping("/gettest")
	public String m1() {
		System.out.println("m1()");
		return "hello";
	}

	@PostMapping("/posttest")
	public String m2() {
		System.out.println("m2()");
		return "hello";
	}
	
	@GetMapping("/gettest3")
	public String m3(String id) {
		System.out.println("m3() ---" + id);
		return "hello " + id;
	}
}
