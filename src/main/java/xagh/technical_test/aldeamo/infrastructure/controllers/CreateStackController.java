package xagh.technical_test.aldeamo.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.CreateStackPort;
import xagh.technical_test.aldeamo.application.ports.MatchNumbersAndCommasOrErrorPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.infrastructure.types.CreateStackDto;
import xagh.technical_test.aldeamo.infrastructure.types.CustomResponseBody;

@RestController
@RequestMapping("/api/stack")
@AllArgsConstructor
public class CreateStackController {

    private final CreateStackPort createStackPort;
    private final MatchNumbersAndCommasOrErrorPort matchNumbersAndCommasOrErrorPort;

    @PostMapping(produces = "application/json")
    public ResponseEntity<CustomResponseBody> createStack(@Valid @RequestBody CreateStackDto data) {
        String stackValid = matchNumbersAndCommasOrErrorPort.invoke(data.getInputArray());
        data.setInputArray(stackValid);
        StackModel model = StackModel.builder().inputArray(data.getInputArray()).build();
        StackModel savedModel = createStackPort.invoke(model);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomResponseBody.builder().status(true).data(savedModel).build());
    }

}
