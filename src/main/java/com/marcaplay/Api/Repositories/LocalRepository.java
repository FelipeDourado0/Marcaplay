package com.marcaplay.Api.Repositories;

import com.marcaplay.Api.Borders.Entities.LocalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface LocalRepository extends MongoRepository<LocalEntity, String> {
}
