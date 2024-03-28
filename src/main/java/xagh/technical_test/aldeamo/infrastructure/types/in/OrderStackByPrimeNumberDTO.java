package xagh.technical_test.aldeamo.infrastructure.types.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderStackByPrimeNumberDTO {

    @NotNull
    @NotBlank
    private Integer iterations;

    @NotBlank
    @NotNull
    private Integer stackId;

}
