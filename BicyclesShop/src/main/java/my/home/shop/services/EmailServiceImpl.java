package my.home.shop.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.from}")
    private String mailFrom;

    @SneakyThrows
    @Override
    public void sendEmail(String email, String subject, String text) {
        MimeMessage message = mailSender.createMimeMessage();
        message.setContent(text, "text/html");
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setTo(email);
        messageHelper.setSubject(subject);
        messageHelper.setText(text, true);
        messageHelper.setFrom(mailFrom);
        mailSender.send(message);
    }
}
