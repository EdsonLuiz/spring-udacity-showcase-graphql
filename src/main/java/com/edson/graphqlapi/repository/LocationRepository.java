package com.edson.graphqlapi.repository;

import com.edson.graphqlapi.entity.Location;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
    
}
