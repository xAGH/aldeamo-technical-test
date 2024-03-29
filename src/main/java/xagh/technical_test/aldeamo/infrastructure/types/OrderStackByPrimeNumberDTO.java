package xagh.technical_test.aldeamo.infrastructure.types;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

// Input DTO to the order process
@Data
public class OrderStackByPrimeNumberDTO {

    @NotNull
    @Positive
    private Integer iterations;

    @NotNull
    @Positive
    @JsonAlias("stack_id")
    private Integer stackId;

}
