package com.random.ChatRoom.global.utils;

import com.random.ChatRoom.core.common.exceptions.ErrorCode;
import com.random.ChatRoom.global.exception.VerificationCodeExpiredException;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationCodeService {

  private final VerificationCodeRepository verificationCodeRepository;

  public String createAndSaveVerificationCode(String toEmail) {
    String verificationCode = createVerificationCode();
    saveVerificationCode(toEmail, verificationCode);
    return verificationCode;
  }

  public boolean checkVerificationCodeAlive(String toEmail, String userSendCode) {
    VerificationCode verificationCode = getVerificationCode(toEmail);
    String savedCode = verificationCode.getCode();

    if (userSendCode.equals(savedCode)) {
      // IllegalArgumentException 터질수도 있음 -> 전역 핸들러에서 잡을 필요 있음
      deleteVerificationCode(toEmail);
      return true;
    }
    else return false;
  }

  private String createVerificationCode() {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      sb.append(random.nextInt(10));
    }
    return sb.toString();
  }

  private void saveVerificationCode(String toEmail, String code) {
    VerificationCode verificationCode = new VerificationCode(toEmail, code, 3L);
    verificationCodeRepository.save(verificationCode);
  }

  private VerificationCode getVerificationCode(String toEmail) {
    return verificationCodeRepository.findById(toEmail)
        .orElseThrow(() -> new VerificationCodeExpiredException(ErrorCode.VERIFICATION_CODE_EXPIRED));
  }

  private void deleteVerificationCode(String toEmail) {
    verificationCodeRepository.deleteById(toEmail);
  }
}
