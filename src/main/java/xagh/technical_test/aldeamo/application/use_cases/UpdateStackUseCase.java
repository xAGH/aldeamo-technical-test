package xagh.technical_test.aldeamo.application.use_cases;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.UpdateStackPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;

@AllArgsConstructor
@UseCase
public class UpdateStackUseCase implements UpdateStackPort {

    private final StackRepository stackRepository;

    @Override
    public StackModel invoke(StackModel model) {
        return this.stackRepository.update(model);
    }

}
