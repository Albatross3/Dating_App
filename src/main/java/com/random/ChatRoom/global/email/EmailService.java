package com.random.ChatRoom.global.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

  private final JavaMailSender javaMailSender;
  private final Random random = new Random();
  private final String subject = "MakeLover 인증코드 메일 💌";
  private final String from = "makeloverwithus@naver.com";
  private final String content =
      "<h2>MakeLover 인증코드입니다 <br> 서비스에 돌아가서 입력해 주세요</h2>\n"
      + "<h3>재현 안뇽~!  </h3>"
      + "<img src=\"cid:love-image\" alt=\"대체 텍스트\">";

  public String sendEmail(String toEmail) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    String verificationCode = createVerificationCode();

    try {
      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

      mimeMessageHelper.setSubject(subject);
      mimeMessageHelper.setFrom(from);
      mimeMessageHelper.setTo(toEmail);

      mimeMessageHelper.setText(content, true);
      mimeMessageHelper.addInline("love-image", new ClassPathResource("static/love.png"));

      javaMailSender.send(mimeMessage);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    return "mail";
  }

  private String createVerificationCode() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      sb.append(random.nextInt(10));
    }
    return sb.toString();
  }

}
