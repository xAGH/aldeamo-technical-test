package xagh.technical_test.aldeamo.infrastructure.types;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Input DTO to create a stack;
@Data
public class CreateStackDto {

    @NotNull
    @Size(min = 1, max = 20)
    @JsonAlias(value = "input_array")
    private String inputArray;

}
