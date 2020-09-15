package addition;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AdditionController {
    
    @RequestMapping(path= "/addition", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE, 
    method = RequestMethod.GET)
    public int add(@RequestParam(value="number1",defaultValue="1")int n1,
    @RequestParam(value="number2", defaultValue="2") int n2) {
        AdditionShop as = new AdditionShop(n1, n2);
        return as.getAddition();
    }
    
}
