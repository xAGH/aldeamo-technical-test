package xagh.technical_test.aldeamo.domain.repositories;

import java.util.List;

import xagh.technical_test.aldeamo.domain.models.StackModel;

public interface StackRepository {
    StackModel save(StackModel model);

    List<StackModel> findAll();

    StackModel findOne(Integer id);

    StackModel update(StackModel model);

    StackModel delete(Integer id);

}