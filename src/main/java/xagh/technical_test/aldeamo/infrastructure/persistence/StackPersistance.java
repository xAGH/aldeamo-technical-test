package xagh.technical_test.aldeamo.infrastructure.persistence;

import java.util.List;

import xagh.technical_test.aldeamo.domain.exceptions.WebException;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;
import xagh.technical_test.aldeamo.infrastructure.annotations.PersistenceAdapter;
import xagh.technical_test.aldeamo.infrastructure.entities.StackEntity;
import xagh.technical_test.aldeamo.infrastructure.mappers.StackMapper;
import xagh.technical_test.aldeamo.infrastructure.repositories.StackRepositoryAdapter;
import xagh.technical_test.aldeamo.domain.Constants;

@PersistenceAdapter
public class StackPersistance implements StackRepository {

    private final StackRepositoryAdapter repository;

    public StackPersistance(StackRepositoryAdapter repository) {
        this.repository = repository;
    }

    @Override
    public StackModel save(StackModel model) {
        model.setInput_array(model.getInput_array().replaceAll("\\s+", ""));
        StackEntity saved = repository.save(StackMapper.modelToEntity(model));
        return StackMapper.entityToModel(saved);
    }

    @Override
    public List<StackModel> findAll() {
        return StackMapper.entityToModel(repository.findAll());
    }

    @Override
    public StackModel findOne(Integer id) {
        return StackMapper.entityToModel(
                repository.findById(id).orElseThrow(() -> new WebException(Constants.stackNotFound(id), 404)));
    }

    @Override
    public StackModel update(StackModel model) {
        this.findOne(model.getId());
        StackEntity updatedModel = repository.save(StackMapper.modelToEntity(model));
        return StackMapper.entityToModel(updatedModel);
    }

    @Override
    public StackModel delete(Integer id) {
        StackModel model = this.findOne(id);
        repository.deleteById(id);
        return model;
    }

}
