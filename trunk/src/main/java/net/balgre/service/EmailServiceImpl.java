package net.balgre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.balgre.mail.MailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	public MailService mailSender;
	
	public void sendSimpleMessage(String to, String mail, String subject, String cName, String mName, String cNumber, String cCEOName, String phone,
			String content) {
		StringBuffer sb = new StringBuffer();
		sb.append("연락처 : ");
		sb.append(phone);
		sb.append("\n");
		sb.append("회사명 : ");
		sb.append(cName);
		sb.append("\n");
		sb.append("담당자명 : ");
		sb.append(mName);
		sb.append("\n");
		sb.append("사업자 등록번호 : ");
		sb.append(cNumber);
		sb.append("\n");
		sb.append("대표자명 : ");
		sb.append(cCEOName);
		sb.append("\n");
		sb.append("이메일 : ");
		sb.append(mail);
		sb.append("\n");
		sb.append("연락처 : ");
		sb.append(phone);
		sb.append("\n");
		sb.append("내용 : ");
		sb.append(content);
		sb.append("\n");
		
		mailSender.sendMail(to, subject, sb.toString());
	}

}
