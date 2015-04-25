package es.uned.services.data.interfaces;

import java.util.List;

import es.uned.model.Message;

public interface MessageService {
	public List<Message> getAllMessages();
	public Message getMessageById(Long id);
	public void save(Message message);
}
