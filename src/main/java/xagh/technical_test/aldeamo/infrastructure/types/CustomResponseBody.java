package xagh.technical_test.aldeamo.infrastructure.types;

import lombok.Builder;
import lombok.Data;

// Output DTO to standard response;
@Data
@Builder
public class CustomResponseBody {
    private Boolean status;
    private String message;
    private Object data;
}
