package xagh.technical_test.aldeamo.application.use_cases;

import java.util.List;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.GetAllStacksPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;

@UseCase
@AllArgsConstructor
public class GetAllStacksUseCase implements GetAllStacksPort {

    private final StackRepository stackRepository;

    @Override
    public List<StackModel> invoke() {
        return this.stackRepository.findAll();
    }

}
