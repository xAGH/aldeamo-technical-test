package xagh.technical_test.aldeamo.application.use_cases;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.CreateInitialDataPort;
import xagh.technical_test.aldeamo.application.ports.CreateStackPort;
import xagh.technical_test.aldeamo.application.ports.GetAllStacksPort;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.infrastructure.annotations.UseCase;

@UseCase
@AllArgsConstructor
public class CreateInitialDataUseCase implements CreateInitialDataPort {

    private final GetAllStacksPort getAllStacksPort;
    private final CreateStackPort createStackPort;

    @Override
    public void createStacks() {
        List<StackModel> stacks = getAllStacksPort.invoke();
        if (stacks.size() == 0) {
            ArrayList<StackModel> models = new ArrayList<StackModel>();
            models.add(new StackModel(1, "2,4,5,6,7,8"));
            models.add(new StackModel(2, "3,7,9,5,4,2"));
            models.add(new StackModel(3, "5,7,9,11,13"));
            models.add(new StackModel(4, "6,4,2,12,15"));
            models.add(new StackModel(5, "7,10,15,11,9"));
            for (StackModel model : models) {
                createStackPort.invoke(model);
            }
        }
    }

}
