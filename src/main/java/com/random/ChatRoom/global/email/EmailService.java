package com.random.ChatRoom.global.email;

import com.random.ChatRoom.core.common.exceptions.ErrorCode;
import com.random.ChatRoom.global.email.exceptions.EmailCreationFailedException;
import com.random.ChatRoom.global.email.exceptions.EmailSendFailedException;
import com.random.ChatRoom.global.utils.VerificationCodeService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
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
  private final VerificationCodeService verificationCodeService;

  public void sendEmailForRegister(String toEmail) {
    MimeMessage mimeMessage = makeEmailForRegister(toEmail);
    sendEmail(mimeMessage);
  }

  private MimeMessage makeEmailForRegister(String toEmail)  {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    String verificationCode = verificationCodeService.createAndSaveVerificationCode(toEmail);

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

    } catch (MessagingException e) {
      throw new EmailCreationFailedException(ErrorCode.EMAIL_CREATION_FAILED);
    }
    return mimeMessage;
  }

  private void sendEmail(MimeMessage mimeMessage) {
    try {
      javaMailSender.send(mimeMessage);
    } catch (MailException e) {
      throw new EmailSendFailedException(ErrorCode.EMAIL_SEND_FAILED);
    }
  }

}
