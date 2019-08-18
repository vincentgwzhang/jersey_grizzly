package poc.jersey.demo.business.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import poc.jersey.demo.server.model.Fruit;

@Service
public class SimpleStorageService {

    private final Map<String, Fruit> fruits = new HashMap<>();

    public void storeFruit(final Fruit fruit) {
        fruits.put(fruit.getName(), fruit);
    }
    
    public Fruit findByName(final String name) {
        return fruits.entrySet()
            .stream()
            .filter(map -> name.equals(map.getKey()))
            .map(map -> map.getValue())
            .findFirst()
            .get();
    }

}
