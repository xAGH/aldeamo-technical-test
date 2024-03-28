package xagh.technical_test.aldeamo.application.use_cases;

import xagh.technical_test.aldeamo.application.ports.UpsertStackPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;
import xagh.technical_test.aldeamo.infrastructure.annotations.UseCase;

@UseCase
public class UpsertStackUseCase implements UpsertStackPort {

    private final StackRepository stackRepository;

    public UpsertStackUseCase(StackRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    @Override
    public StackModel invoke(StackModel model) {
        return this.stackRepository.save(model);
    }

}
