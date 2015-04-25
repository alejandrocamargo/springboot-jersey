package es.uned.services.rest;


import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uned.model.Message;
import es.uned.services.data.interfaces.MessageService;
 
@Component
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class RestAPI {
	
	@Autowired
	MessageService messageService;

	
	@GET
	public List<Message> getAllMessage() {
		return messageService.getAllMessages();
	}

	@GET
	@Path("{id}")
	public Message getMessage( @PathParam("id") Long id ) {
		return messageService.getMessageById(id);
	}
	
	@POST
	public void save(@Valid Message message) {
        messageService.save(message);
    }
 
}
