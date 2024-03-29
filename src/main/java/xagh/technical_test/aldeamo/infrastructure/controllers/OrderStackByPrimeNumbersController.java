package xagh.technical_test.aldeamo.infrastructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.GetStackByIdPort;
import xagh.technical_test.aldeamo.application.ports.OrderStackByPrimeNumbersPort;
import xagh.technical_test.aldeamo.infrastructure.types.OrderStackByPrimeNumberDTO;
import xagh.technical_test.aldeamo.infrastructure.types.CustomResponseBody;

@RestController
@RequestMapping("/api/stack")
@AllArgsConstructor
public class OrderStackByPrimeNumbersController {

    private final OrderStackByPrimeNumbersPort orderStackByPrimeNumbersPort;
    private final GetStackByIdPort getStackByIdPort;

    @PostMapping(value = "/order", produces = "application/json")
    public ResponseEntity<CustomResponseBody> orderStackByPrimeNumbers(
            @Valid @RequestBody OrderStackByPrimeNumberDTO data) {
        String stack = getStackByIdPort.invoke(data.getStackId()).getInputArray();
        Integer iterations = data.getIterations();
        List<Integer> result = orderStackByPrimeNumbersPort.invoke(iterations, stack);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomResponseBody.builder().status(true).data(result).build());
    }

}
