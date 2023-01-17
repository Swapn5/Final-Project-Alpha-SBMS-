package com.creditmanager.controller;

import java.util.HashMap;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditmanager.feign.CreditFeignEnq;
import com.creditmanager.feign.CreditFeignRE;
import com.creditmanager.model.Customer;
import com.creditmanager.model.Email;
import com.creditmanager.model.Enquiry;

import freemarker.template.Configuration;
import freemarker.template.Template;

@RestController
@RequestMapping("email")
@CrossOrigin(origins ="http://localhost:4200")
public class EmailController {

	@Autowired
	private JavaMailSenderImpl sender;
	
	@Autowired
	private Configuration freeMarker;
	
	@Autowired
	private CreditFeignRE feign;
	
	@Autowired
	private CreditFeignEnq enfeign;
	
	
	@GetMapping ("/loanApprovalEmail/{cid}")
	public ResponseEntity<String> loanApprovalEmail(@PathVariable Integer cid) throws Exception
	{
		System.out.println("########################");
		Customer customer = feign.getSingleCustomer(cid);
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		freeMarker.setClassForTemplateLoading(this.getClass(), "/templates");
		Template t= freeMarker.getTemplate("email-finance-approval.ftl");
		
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("Name", customer.getCname());
		model.put("Amount",customer.getLoan().getExpAmount());
		model.put("id",customer.getCid());
		
		Email email = new Email();
		email.setModel(model);
		
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, email.getModel());
		helper.setTo(customer.getEmail());
		helper.setText(text, true);
		helper.setSubject("Loan Approved");
		sender.send(message);
		return new ResponseEntity<String>("Email sent", HttpStatus.OK);
	}
	
	@GetMapping ("/loanRejectionEmail/{cid}")
	public ResponseEntity<String> loanRejectionEmail(@PathVariable Integer cid) throws Exception
	{
		Customer customer = feign.getSingleCustomer(cid);
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		freeMarker.setClassForTemplateLoading(this.getClass(), "/templates");
		Template t= freeMarker.getTemplate("email-finance-rejection.ftl");
		
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("Name", customer.getCname());
		
		Email email = new Email();
		email.setModel(model);
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, email.getModel());
		helper.setTo(customer.getEmail());
		helper.setText(text, true);
		helper.setSubject("Loan Application Rejected");
		sender.send(message);
		
		return new ResponseEntity<String>("Email sent", HttpStatus.OK);
	}
	
	@GetMapping ("/enqRejectionEmail/{custId}")
	public ResponseEntity<String> enquiryRejectionEmail(@PathVariable Integer custId) throws Exception
	{
		Enquiry enquiry = enfeign.getSingleEnquiry(custId);
		
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		freeMarker.setClassForTemplateLoading(this.getClass(), "/templates");
		Template t= freeMarker.getTemplate("email-enquiry-rejection.ftl");
		
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("Name", enquiry.getCustomerName());
		
		Email email = new Email();
		email.setModel(model);
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, email.getModel());
		helper.setTo(enquiry.getCustomerEmailId());
		helper.setText(text, true);
		helper.setSubject("Loan Enquiry Declined");
		sender.send(message);
		
		return new ResponseEntity<String>("Email sent", HttpStatus.OK);
	}

}
