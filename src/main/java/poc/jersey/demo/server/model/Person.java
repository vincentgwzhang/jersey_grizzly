package poc.jersey.demo.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Person {

    private String name;

    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
}