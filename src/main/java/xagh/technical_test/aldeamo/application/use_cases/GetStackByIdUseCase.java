package xagh.technical_test.aldeamo.application.use_cases;

import xagh.technical_test.aldeamo.application.ports.GetStackByIdPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;
import xagh.technical_test.aldeamo.infrastructure.annotations.UseCase;

@UseCase
public class GetStackByIdUseCase implements GetStackByIdPort {

    private final StackRepository stackRepository;

    public GetStackByIdUseCase(StackRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    @Override
    public StackModel invoke(Integer id) {
        return stackRepository.findOne(id);
    }

}
