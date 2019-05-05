package org.thibaut.thelibrary.webservice.endpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.thibaut.thelibrary.domain.entity.User;
import org.thibaut.thelibrary.service.contract.ServiceFactory;
import org.thibaut.thelibrary.webservice.generated.jaxb2.GetUserRequest;
import org.thibaut.thelibrary.webservice.generated.jaxb2.GetUserResponse;

import java.lang.reflect.Type;

@Endpoint
public class UserEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ServiceFactory serviceFactory;

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public UserEndpoint(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser( @RequestPayload GetUserRequest request ){

		GetUserResponse response = new GetUserResponse();

		User user = serviceFactory.getUserService().findByEmail( request.getEmail() );

		org.thibaut.thelibrary.webservice.generated.jaxb2.User userResponse = modelMapper.map( user, org.thibaut.thelibrary.webservice.generated.jaxb2.User.class );

		response.setUser( userResponse );

		return response;
	}

}
