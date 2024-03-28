package xagh.technical_test.aldeamo.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import xagh.technical_test.aldeamo.application.ports.UpsertStackPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.infrastructure.entities.StackEntity;
import xagh.technical_test.aldeamo.infrastructure.mappers.StackMapper;
import xagh.technical_test.aldeamo.infrastructure.types.out.CustomResponseBody;

@RestController
@RequestMapping("/api/stack")
public class UpsertStackController {

    private final UpsertStackPort upsertStackPort;

    public UpsertStackController(UpsertStackPort upsertStackPort) {
        this.upsertStackPort = upsertStackPort;
    }

    @PostMapping()
    public ResponseEntity<CustomResponseBody> getAllStacks(@Valid @RequestBody StackEntity entity) {
        StackModel savedModel = upsertStackPort.invoke(StackMapper.entityToModel(entity));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomResponseBody.builder().status(true).data(savedModel).build());
    }

}
