package xagh.technical_test.aldeamo.infrastructure.persistence;

import java.util.List;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.domain.exceptions.StackNotFoundException;
import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.domain.repositories.StackRepository;
import xagh.technical_test.aldeamo.infrastructure.annotations.PersistenceAdapter;
import xagh.technical_test.aldeamo.infrastructure.entities.StackEntity;
import xagh.technical_test.aldeamo.infrastructure.mappers.StackMapper;
import xagh.technical_test.aldeamo.infrastructure.repositories.StackRepositoryAdapter;

@AllArgsConstructor
@PersistenceAdapter
public class StackPersistance implements StackRepository {

    private final StackRepositoryAdapter repository;

    @SuppressWarnings("null")
    @Override
    public StackModel save(StackModel model) {
        StackEntity saved = repository.save(StackMapper.modelToEntity(model));
        return StackMapper.entityToModel(saved);
    }

    @Override
    public List<StackModel> findAll() {
        return StackMapper.entityToModel(repository.findAll());
    }

    @SuppressWarnings("null")
    @Override
    public StackModel findOne(Integer id) {
        return StackMapper.entityToModel(
                repository.findById(id).orElseThrow(() -> new StackNotFoundException(id)));
    }

    @SuppressWarnings("null")
    @Override
    public StackModel update(StackModel model) {
        this.findOne(model.getId());
        StackEntity updatedModel = repository.save(StackMapper.modelToEntity(model));
        return StackMapper.entityToModel(updatedModel);
    }

    @SuppressWarnings("null")
    @Override
    public StackModel delete(Integer id) {
        StackModel model = this.findOne(id);
        repository.deleteById(id);
        return model;
    }

}
