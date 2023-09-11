package com.random.ChatRoom.global.email.dto.request;

public record EmailVerifyRequest(String toEmail, String verificationCode) {

}
