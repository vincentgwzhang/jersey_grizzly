package poc.jersey.demo.server.exceptions.mapper;

import poc.jersey.demo.server.exceptions.exception.BusinessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

public class SystemExceptionMapper {

    @Provider
    public static class BusinessExceptionMapper extends BasicExceptionMapper implements ExceptionMapper<BusinessException> {
        @Override
        public Response toResponse(BusinessException exception) {
            return this.buildResponse(Response.Status.BAD_REQUEST, exception);
        }
    }

}
