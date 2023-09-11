package com.random.ChatRoom.global.utils;

import java.util.concurrent.TimeUnit;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@RedisHash("VerificationCode")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VerificationCode {

  @Id
  private String email;

  private String code;

  @TimeToLive(unit = TimeUnit.MINUTES)
  private Long expirationTime;

  public VerificationCode(String email, String code, Long expirationTime) {
    this.email = email;
    this.code = code;
    this.expirationTime = expirationTime;
  }

}
