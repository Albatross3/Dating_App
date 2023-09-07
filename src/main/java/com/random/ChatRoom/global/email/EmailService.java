package com.random.ChatRoom.global.email;

import com.random.ChatRoom.core.common.exceptions.ErrorCode;
import com.random.ChatRoom.global.email.exceptions.EmailCreationFailedException;
import com.random.ChatRoom.global.email.exceptions.EmailSendFailedException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
@RequiredArgsConstructor
public class EmailService {

  private final JavaMailSender javaMailSender;
  private final SpringTemplateEngine springTemplateEngine;

  public void sendEmailForRegister(String toEmail) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    String verificationCode = createVerificationCode();

    try {
      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

      mimeMessageHelper.setSubject("MakeLover 인증코드 메일 💌");
      mimeMessageHelper.setFrom("makeloverwithus@naver.com");
      mimeMessageHelper.setTo(toEmail);

      Context context = new Context();
      context.setVariable("code", verificationCode);

      String emailContent = springTemplateEngine.process("mail.html", context);
      mimeMessageHelper.setText(emailContent, true);
      mimeMessageHelper.addInline("love-image", new ClassPathResource("static/love.png"));

      javaMailSender.send(mimeMessage);

    } catch (MessagingException e) {
      throw new EmailCreationFailedException(ErrorCode.EMAIL_CREATION_FAILED);
    } catch (MailException e) {
      throw new EmailSendFailedException(ErrorCode.EMAIL_SEND_FAILED);
    }
  }

  private String createVerificationCode() {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      sb.append(random.nextInt(10));
    }
    return sb.toString();
  }

}
