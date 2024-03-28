package xagh.technical_test.aldeamo.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xagh.technical_test.aldeamo.application.ports.DeleteStackPort;
import xagh.technical_test.aldeamo.application.ports.ParseStringToIntegerPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.infrastructure.types.out.CustomResponseBody;

@RestController
@RequestMapping("/api/stack")
public class DeleteStackController {

    private final DeleteStackPort deleteStackPort;
    private final ParseStringToIntegerPort parseStringToIntegerPort;

    public DeleteStackController(DeleteStackPort deleteStackPort, ParseStringToIntegerPort parseStringToIntegerPort) {
        this.deleteStackPort = deleteStackPort;
        this.parseStringToIntegerPort = parseStringToIntegerPort;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponseBody> deleteStack(@PathVariable("id") String id) {
        Integer idInt = parseStringToIntegerPort.invoke(id);
        StackModel deletedStack = deleteStackPort.invoke(idInt);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomResponseBody.builder().status(true).data(deletedStack).build());
    }
}