package com.marcaplay.Api.Repositories;

import com.marcaplay.Api.Borders.Entities.AtletaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AtletaRepository extends MongoRepository<AtletaEntity, String> {
}
