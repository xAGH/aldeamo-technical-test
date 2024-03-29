package xagh.technical_test.aldeamo.infrastructure.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponseBody {
    private Boolean status;
    private String message;
    private Object data;
}
