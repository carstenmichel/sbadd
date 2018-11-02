package addition;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AdditionController {
    
    @RequestMapping("/addition")
    public String add(@RequestParam(value="number1",defaultValue="1")int n1,
    @RequestParam(value="number2", defaultValue="2") int n2) {
        AdditionShop as = new AdditionShop(n1, n2);
        StringBuilder sb=new StringBuilder("Addition of ");
        sb.append(as.getNumber1()).append(" and ");
        sb.append(as.getNumber2()).append(" is ");
        sb.append(as.getAddition());
        return sb.toString();
    }
    
}
