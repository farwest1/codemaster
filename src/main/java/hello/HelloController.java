package hello;

import com.moeller.decenc.domain.LamdaTest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        LamdaTest lamdaTest = new LamdaTest();
        lamdaTest.listPersons();
        return "Greetings from Spring Boot!";
    }
    
}
