package xagh.technical_test.aldeamo.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import xagh.technical_test.aldeamo.infrastructure.entities.StackEntity;

public interface StackRepositoryAdapter extends JpaRepository<StackEntity, Integer> {
}