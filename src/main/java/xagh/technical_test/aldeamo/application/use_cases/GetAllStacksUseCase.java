package xagh.technical_test.aldeamo.application.use_cases;

import java.util.List;

import xagh.technical_test.aldeamo.application.ports.GetAllStacksPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;
import xagh.technical_test.aldeamo.infrastructure.annotations.UseCase;

@UseCase
public class GetAllStacksUseCase implements GetAllStacksPort {

    private final StackRepository stackRepository;

    public GetAllStacksUseCase(StackRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    @Override
    public List<StackModel> invoke() {
        return this.stackRepository.findAll();
    }

}
