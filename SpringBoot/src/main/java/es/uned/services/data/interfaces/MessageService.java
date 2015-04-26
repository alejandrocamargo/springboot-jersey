package es.uned.services.data.interfaces;

import java.util.List;

import es.uned.model.Message;

public interface MessageService {
	public List<Message> getAllMessages();
	public Message getMessageById(Long id);
	public Long saveMessage(Message message);
	public boolean deleteMessage(long id);
	public boolean updateMessage(Long id, Message message);
}
