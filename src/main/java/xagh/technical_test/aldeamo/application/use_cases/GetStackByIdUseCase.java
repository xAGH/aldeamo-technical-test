package xagh.technical_test.aldeamo.application.use_cases;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.GetStackByIdPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;

@UseCase
@AllArgsConstructor
public class GetStackByIdUseCase implements GetStackByIdPort {

    private final StackRepository stackRepository;

    @Override
    public StackModel invoke(Integer id) {
        return stackRepository.findOne(id);
    }

}
