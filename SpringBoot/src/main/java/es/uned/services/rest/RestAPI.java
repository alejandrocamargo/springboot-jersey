package es.uned.services.rest;


import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;
 
@Component
@Path("/rest")
public class RestAPI {
	@GET
	@Produces("application/xml")
	public String sayHelloXML() {
		return "<messages><message>Hello world</message></messages>";
	}
 
}
