package com.sivasoft;

/**
 * High-level modules should not depend on low-level modules. Both should depend
 * on abstractions. Abstraction should not depend on details.Details should
 * depend on abstractions High level and Low level both has to depend on
 * abstraction. That's the perfect design
 * 
 */
public class DependencyInversionPrinciple {
	public static void main(String[] args) {
		NotifyCustomer notifyCustomer = new NotifyCustomer(new MailService());
		notifyCustomer.notifyCustomer();
		NotifyCustomer notifyCustomerSms = new NotifyCustomer(new SmsService());
		notifyCustomerSms.notifyCustomer();
		NotifyCustomer notifyCustomerPush = new NotifyCustomer(new PushService());
		notifyCustomerPush.notifyCustomer();
		// notifyCustomer.notifyCustomerByMail();
		// notifyCustomer.notifyCustomerBySMS();
	}
}

interface INotifyService {
	void notifyCustomer();
}

class MailService implements INotifyService {
	/*
	 * public void sendMail() { System.out.println("Mail sent to Customer"); }
	 */
	@Override
	public void notifyCustomer() {
		System.out.println("Mail sent to Customer");
	}
}

class SmsService implements INotifyService {
	/*
	 * public void sendSms() { System.out.println("SMS sent to Customer"); }
	 */
	@Override
	public void notifyCustomer() {
		System.out.println("SMS sent to Customer");
	}
}

class PushService implements INotifyService {

	@Override
	public void notifyCustomer() {
		System.out.println("Notification sent to Customer mobile");
	}
}

class NotifyCustomer {
	/*
	 * private MailService mailService; private SmsService smsService;
	 */
	INotifyService service;

	NotifyCustomer(INotifyService service) {
		this.service = service;
	}

	public void notifyCustomer() {
		service.notifyCustomer();
	}

	/*
	 * NotifyCustomer(SmsService smsService){ this.smsService = smsService; } public
	 * void notifyCustomerByMail() { mailService.sendMail(); }
	 * 
	 * public void notifyCustomerBySMS() { smsService.sendSms(); }
	 */

}