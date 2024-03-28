package xagh.technical_test.aldeamo.application.use_cases;

import xagh.technical_test.aldeamo.application.ports.DeleteStackPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;
import xagh.technical_test.aldeamo.infrastructure.annotations.UseCase;

@UseCase
public class DeleteStackUseCase implements DeleteStackPort {

    private final StackRepository stackRepository;

    public DeleteStackUseCase(StackRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    @Override
    public StackModel invoke(Integer id) {
        return this.stackRepository.delete(id);
    }

}
