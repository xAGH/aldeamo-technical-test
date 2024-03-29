package xagh.technical_test.aldeamo.application.use_cases;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.CreateStackPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;

@UseCase
@AllArgsConstructor
public class CreateStackUseCase implements CreateStackPort {

    private final StackRepository stackRepository;

    @Override
    public StackModel invoke(StackModel model) {
        return this.stackRepository.save(model);
    }

}
