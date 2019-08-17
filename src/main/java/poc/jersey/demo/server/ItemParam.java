package poc.jersey.demo.server;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;

@Getter
@Setter
@ToString
public class ItemParam {

    @HeaderParam("headerParam")
    private String shopKey;

    @PathParam("pathParam")
    private String itemId;

    @FormParam("formParam")
    private String price;

}
