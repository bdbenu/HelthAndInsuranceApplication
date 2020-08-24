/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.helth.insurance.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.helth.insurance.domain.CaseWorkerMaster;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendUserAccUnlockEmail(CaseWorkerMaster caseworkermaster) {
			boolean isSent=false;
			//Properties props=new Properties();
			//props.put("spring.mail.properties.mail.smtp.starttls.enable",true);
		try {
				MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
				mimeMessageHelper.setTo(caseworkermaster.getCaseWorkerEmail());
				mimeMessageHelper.setSubject("Unlock your Account");
				mimeMessageHelper.setText(getUnlockAccEmailBody(caseworkermaster), true);
				javaMailSender.send(mimeMessage);
				isSent=true;
		} catch (Exception e) {
			e.printStackTrace();
			isSent=false;
		}
		return isSent;
	}
	public String getUnlockAccEmailBody(CaseWorkerMaster caseworkermaster) throws IOException {
		
		StringBuffer buffer=new StringBuffer("");
		FileReader fileReader= new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		while (line != null) {
			buffer.append(line);
			line= bufferedReader.readLine();
		}
		bufferedReader.close();
		
//		format mail Body
		String mailBody=buffer.toString();
		mailBody = mailBody.replace("{FNAME}", caseworkermaster.getFirstName());
		mailBody = mailBody.replace("{LNAME}", caseworkermaster.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", caseworkermaster.getTempPazzword());
		mailBody = mailBody.replace("{EMAIL}", caseworkermaster.getCaseWorkerEmail());
		return mailBody;
		
	}
}
