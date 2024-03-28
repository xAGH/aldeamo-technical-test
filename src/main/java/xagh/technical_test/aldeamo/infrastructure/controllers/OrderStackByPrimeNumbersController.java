package xagh.technical_test.aldeamo.infrastructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import xagh.technical_test.aldeamo.application.ports.GetStackByIdPort;
import xagh.technical_test.aldeamo.application.ports.OrderStackByPrimeNumbersPort;
import xagh.technical_test.aldeamo.infrastructure.types.in.OrderStackByPrimeNumberDTO;
import xagh.technical_test.aldeamo.infrastructure.types.out.CustomResponseBody;

@RestController
@RequestMapping("/api/stack")
public class OrderStackByPrimeNumbersController {

    private final OrderStackByPrimeNumbersPort orderStackByPrimeNumbersPort;
    private final GetStackByIdPort getStackByIdPort;

    public OrderStackByPrimeNumbersController(
            OrderStackByPrimeNumbersPort orderStackByPrimeNumbersPort,
            GetStackByIdPort getStackByIdPort) {
        this.orderStackByPrimeNumbersPort = orderStackByPrimeNumbersPort;
        this.getStackByIdPort = getStackByIdPort;
    }

    @PostMapping("/order")
    public ResponseEntity<CustomResponseBody> orderStackByPrimeNumbers(
            @Valid @RequestBody OrderStackByPrimeNumberDTO data) {
        String stack = getStackByIdPort.invoke(data.getStackId()).getInput_array();
        Integer iterations = data.getIterations();
        List<Integer> result = orderStackByPrimeNumbersPort.invoke(iterations, stack);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomResponseBody.builder().status(true).data(result).build());
    }

}
