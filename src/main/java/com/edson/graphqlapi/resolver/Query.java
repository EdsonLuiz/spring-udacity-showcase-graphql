package com.edson.graphqlapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.edson.graphqlapi.entity.Location;
import com.edson.graphqlapi.repository.LocationRepository;

import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private LocationRepository locationRepository;

    public Query(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations() {
        return locationRepository.findAll();
    }
    
}
