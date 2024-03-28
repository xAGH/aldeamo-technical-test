package xagh.technical_test.aldeamo.application.ports;

import java.util.List;

import xagh.technical_test.aldeamo.domain.models.StackModel;

public interface GetAllStacksPort {
    List<StackModel> invoke();
}
