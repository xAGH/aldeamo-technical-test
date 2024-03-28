package xagh.technical_test.aldeamo.application.ports;

import xagh.technical_test.aldeamo.domain.models.StackModel;

public interface UpsertStackPort {
    StackModel invoke(StackModel model);
}