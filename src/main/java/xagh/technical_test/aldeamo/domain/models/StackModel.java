package xagh.technical_test.aldeamo.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class StackModel {
    private Integer id; // Stack id
    private String input_array; // Numbers separated by commas that indicate stack members
}