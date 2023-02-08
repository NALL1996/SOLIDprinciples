package com.sivasoft;

/**
 * Functionality or classes should be open extendable but closed for
 * modification. Existing functionality cannot be modified, if there is a new
 * change it has to extend the functionality not to impact the existing code
 * Classes, functions and module are open for extension Basically we are going
 * to use abstract class to extent its functionality One way is to make use of
 * polymorphism to invoke extended behaviours of an project at run time.
 */
public class OpenClosedPrinciple {
	public static void main(String[] args) {
//	Notification.notifyCustomer(Notification.messageType.EMAIL,"Your application has been received");	
//	Notification.notifyCustomer(Notification.messageType.SMS,"Your application has been received");
//	Notification.notifyCustomer(Notification.messageType.PUSH  ,"Your application has been received");
		Notification emailNotification = new EmailNotification();
		emailNotification.notifyCustomer("Your application has been received");
		Notification smsNotification = new SmsNotification();
		smsNotification.notifyCustomer("Your application has been received");
		Notification pushNotification = new PushNotification();
		pushNotification.notifyCustomer("Your application has been received");
	}
}

abstract class Notification {
	public abstract void notifyCustomer(String messageBody);
}

class EmailNotification extends Notification {
	@Override
	public void notifyCustomer(String messageBody) {
		System.out.println("Email sent. Content is :" + messageBody);
	}
}

class SmsNotification extends Notification {
	@Override
	public void notifyCustomer(String messageBody) {
		System.out.println("Message sent. content is :" + messageBody);
	}
}

class PushNotification extends Notification {
	@Override
	public void notifyCustomer(String messageBody) {
		System.out.println("Push Notification sent. content is :" + messageBody);
	}
}

/*
 * class NotificationImpl{ static String messageBody; static public void
 * notifyCustomer(messageType type,String message) {
 * if(type.equals(messageType.EMAIL)) {
 * System.out.println("Email sent . content is :"+message); }
 * if(type.equals(messageType.SMS)) {
 * System.out.println("SMS sent . content is :"+message); }
 * if(type.equals(messageType.PUSH)) {
 * System.out.println("PUSH sent . content is :"+message); } } enum
 * messageType{SMS,EMAIL,PUSH} }
 */
