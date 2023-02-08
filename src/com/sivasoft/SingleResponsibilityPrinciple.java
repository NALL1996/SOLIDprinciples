package com.sivasoft;

/**
 * each class have single responsibility and single purpose A class should have
 * only one reason to change A class should have only one responsibilty Makes
 * your software easier to implement and avoid unexcepted future changes Much
 * easier to understand and explain.
 */
public class SingleResponsibilityPrinciple {
	public static void main(String[] args) {
		IContentService service = new MessageServiceImpl();
		service.writeMessage("HI Welcome to Java Design Patterns");
		// service.printMessage();
		service.replaceMessageContent("HI", "Hello");
		// service.printMessage();
		// service.sendMessage();
	}
}

interface IContentService {
	void writeMessage(String msg);

	void replaceMessageContent(String source, String destination);

}

interface IMessageService {
	void printMessage(String content);

	void sendMessage(String content);
}

class MessageImpl implements IMessageService {

	@Override
	public void printMessage(String content) {
		System.out.println("Message is:: :" + content);
	}

	@Override
	public void sendMessage(String content) {
		System.out.println("Message sent and the content is :" + content);
	}

}

class MessageServiceImpl implements IContentService {
	String content;
	IMessageService service = new MessageImpl();

	@Override
	public void writeMessage(String msg) {
		content = msg;
		service.printMessage(content);
	}

	@Override
	public void replaceMessageContent(String source, String destination) {
		content = content.replace(source, destination);
		service.sendMessage(content);
	}
}
