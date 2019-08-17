package poc.jersey.demo.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fruit {

    @Min(value = 10, message = "Fruit weight must be 10 or greater")
    private Integer weight;

    @Size(min = 5, max = 200)
    private String name;

    @Size(min = 5, max = 200)
    private String colour;

    private String serial;

    public Fruit(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }
}
