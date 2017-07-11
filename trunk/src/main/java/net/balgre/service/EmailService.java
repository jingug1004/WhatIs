package net.balgre.service;

public interface EmailService {
	
	public void sendSimpleMessage(String to, String mail, String subject, String cName, String mName, String cNumber, String cCEOName, String phone, String content);

}
