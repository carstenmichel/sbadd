package addition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarkerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

  Logger logger = LoggerFactory.getLogger(AdditionController.class);

  @PostMapping(path = "/addition", consumes = {"application/json"}, produces = {"application/json"})
  public ResultPojo add(@RequestBody NumberInputPojo numbers) {

    final Marker addingMarker = new BasicMarkerFactory().getMarker("ADDER");
    final AdditionShop as = new AdditionShop(numbers.getN1(), numbers.getN2());
    logger.trace(addingMarker, "Adding numbers n1={} and n2={}", numbers.getN1(), numbers.getN2());
    return new ResultPojo(as.getAddition());
  }

}
