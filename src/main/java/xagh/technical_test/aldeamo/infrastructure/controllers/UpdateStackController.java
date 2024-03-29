package xagh.technical_test.aldeamo.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.MatchNumbersAndCommasOrErrorPort;
import xagh.technical_test.aldeamo.application.ports.UpdateStackPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.infrastructure.types.CustomResponseBody;
import xagh.technical_test.aldeamo.infrastructure.types.UpdateStackDTO;

@RestController
@RequestMapping("/api/stack")
@AllArgsConstructor
public class UpdateStackController {

    private final UpdateStackPort updateStackPort;
    private final MatchNumbersAndCommasOrErrorPort matchNumbersAndCommasOrErrorPort;

    @PutMapping(produces = "application/json")
    public ResponseEntity<CustomResponseBody> updateStack(@Valid @RequestBody UpdateStackDTO data) {
        String stackValid = matchNumbersAndCommasOrErrorPort.invoke(data.getInputArray());
        data.setInputArray(stackValid);
        StackModel model = new StackModel(data.getId(), data.getInputArray());
        StackModel savedModel = updateStackPort.invoke(model);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomResponseBody.builder().status(true).data(savedModel).build());
    }

}
