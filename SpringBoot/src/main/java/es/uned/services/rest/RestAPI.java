package es.uned.services.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uned.model.Message;
import es.uned.services.data.interfaces.MessageService;
 
@Component
@Path("/messages")
public class RestAPI {
	
	@Autowired
	MessageService messageService;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessage() {
		return messageService.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMessage(Message message) {
		Response response;
        Long id = messageService.saveMessage(message);
        
        if (id != null) {
        	response = Response.status(201).entity(id).build();
        } else {
        	response = Response.status(500).entity(null).build();     
        }
        return response;
    }

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("id") Long id) {
		Response response;
		Message message = messageService.getMessageById(id);
		
		if (message != null) {
			response = Response.status(200).entity(message).build();
		} else {
			response = Response.status(404).entity(null).build();   
		}
		return response;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteMessage(@PathParam("id") Long id) {
		Response response;
		
		if(messageService.deleteMessage(id)){
			response = Response.status(200).entity(null).build();
		} else{
			response = Response.status(404).entity(null).build();
		}
		return response;
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMessage(@PathParam("id") Long id, Message message) {
		Response response;
		
		if (messageService.updateMessage(id, message)) {
			response = Response.status(200).entity(null).build();
		} else {
			response = Response.status(404).entity(null).build();
		}
		
		return response;
	}
}
