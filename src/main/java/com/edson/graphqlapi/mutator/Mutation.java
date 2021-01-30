package com.edson.graphqlapi.mutator;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.edson.graphqlapi.entity.Location;
import com.edson.graphqlapi.exception.LocationNotFoundException;
import com.edson.graphqlapi.repository.LocationRepository;

import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private LocationRepository locationRepository;

    public Mutation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location newLocation(String name, String address) {
        Location location = new Location(name, address);
        locationRepository.save(location);
        return location;
    }

    public boolean deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return true;
    }

    public Location updateLocationName(String newName, Long id) {
        Optional<Location> optionalLocation =
                locationRepository.findById(id);

        if(optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setName(newName);
            locationRepository.save(location);
            return location;
        } else {
            throw new LocationNotFoundException("Location Not Found", id);
        }
    }
}
