package addition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarkerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    Logger logger = LoggerFactory.getLogger(AdditionController.class);

    @GetMapping(path = "/addition", produces = { "application/json" })
    public String add(@RequestParam(value = "number1", defaultValue = "1") final int n1,
            @RequestParam(value = "number2", defaultValue = "2") final int n2) {

        final Marker addingMarker = new BasicMarkerFactory().getMarker("ADDER");
        final AdditionShop as = new AdditionShop(n1, n2);
        logger.trace(addingMarker, "Adding numbers n1={} and n2={}", n1, n2);
        return Integer.toString(as.getAddition());
    }

}
