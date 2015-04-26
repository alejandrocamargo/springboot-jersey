package es.uned.services.data.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.uned.model.Message;
import es.uned.services.data.interfaces.MessageService;

@Service
@Qualifier("messageService")
public class MessageServiceImpl implements MessageService {
	
	private HashMap<Long, Message> hashMessages= new HashMap<Long, Message>();
	private long idMensaje = 0;
	
	@PostConstruct
	private void init() {
		Message m1 = new Message();
		m1.setAutor("Pepe Pepon");
		m1.setTitulo("Mensaje cero");
		m1.setTexto("Este es un primer mensaje de prueba");
		m1.setFecha(new Date());
		
		this.saveMessage(m1);
		
		Message m2 = new Message();
		m2.setAutor("Federico perez");
		m2.setTitulo("Mensaje uno");
		m2.setTexto("Este es un segundo mensaje de prueba");
		m2.setFecha(new Date());
		
		this.saveMessage(m2);
	}
	
	public List<Message> getAllMessages() {
		List<Message> messagesList = new ArrayList<Message>();
		
		Iterator it = hashMessages.entrySet().iterator();
	    while (it.hasNext()) {
	        HashMap.Entry pair = (HashMap.Entry)it.next();
	        messagesList.add((Message)pair.getValue());
	    }
	    return messagesList;		
	}
	
	public Message getMessageById(Long id) {
		return hashMessages.get(id);
	}
	
	public Long saveMessage(Message message) {
		message.setId(idMensaje);
		hashMessages.put(idMensaje, message);
		idMensaje++;
		return message.getId();
	}
	
	public boolean deleteMessage(long id) {
		if (hashMessages.get(id) != null) {
			hashMessages.remove(id);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateMessage(Long id, Message message) {
		if (hashMessages.get(id) != null) {
			hashMessages.remove(id);
			message.setId(id);
			hashMessages.put(id, message);
			return true;
		} else {
			return false;
		}
	}
}
