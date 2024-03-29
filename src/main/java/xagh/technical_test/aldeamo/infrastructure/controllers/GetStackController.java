package xagh.technical_test.aldeamo.infrastructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.GetAllStacksPort;
import xagh.technical_test.aldeamo.application.ports.GetStackByIdPort;
import xagh.technical_test.aldeamo.application.ports.ParseStringToIntegerPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.infrastructure.types.CustomResponseBody;

@RestController
@RequestMapping("/api/stack")
@AllArgsConstructor
public class GetStackController {

    private final GetStackByIdPort getStackByIdPort;
    private final GetAllStacksPort getAllStacksPort;
    private final ParseStringToIntegerPort parseStringToIntegerPort;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CustomResponseBody> getStackById(@PathVariable("id") String id) {
        Integer idInt = parseStringToIntegerPort.invoke(id);
        StackModel model = getStackByIdPort.invoke(idInt);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomResponseBody.builder().status(true).data(model).build());
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<CustomResponseBody> getAllStacks() {
        List<StackModel> models = getAllStacksPort.invoke();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomResponseBody.builder().status(true).data(models).build());
    }

}
