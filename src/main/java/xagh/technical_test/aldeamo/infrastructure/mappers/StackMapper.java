package xagh.technical_test.aldeamo.infrastructure.mappers;

import java.util.ArrayList;
import java.util.List;

import xagh.technical_test.aldeamo.domain.models.StackModel;
import xagh.technical_test.aldeamo.infrastructure.entities.StackEntity;

public class StackMapper {

    public static StackModel entityToModel(StackEntity entity) {
        return StackModel
                .builder()
                .id(entity.getId())
                .inputArray(entity.getInputArray())
                .build();
    }

    public static List<StackModel> entityToModel(List<StackEntity> entities) {
        ArrayList<StackModel> models = new ArrayList<StackModel>();
        for (StackEntity entity : entities) {
            models.add(StackModel
                    .builder()
                    .id(entity.getId())
                    .inputArray(entity.getInputArray())
                    .build());
        }
        return models;
    }

    public static StackEntity modelToEntity(StackModel model) {
        return StackEntity
                .builder()
                .id(model.getId())
                .inputArray(model.getInputArray())
                .build();
    }

    public static List<StackEntity> modelToEntity(List<StackModel> models) {
        ArrayList<StackEntity> entities = new ArrayList<StackEntity>();
        for (StackModel model : models) {
            entities.add(StackEntity
                    .builder()
                    .id(model.getId())
                    .inputArray(model.getInputArray())
                    .build());
        }
        return entities;
    }

}
