package com.lucasko.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CaptchaCaptureFilter extends OncePerRequestFilter {
 
private String recaptcha_response;
private String recaptcha_challenge;
private String remoteAddr;

@Override
public void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
  FilterChain chain) throws IOException, ServletException {
 
 
 if (req
         .getParameter("g-recaptcha-response")    != null) {
  remoteAddr = req.getRemoteAddr();
  recaptcha_response = req
	         .getParameter("g-recaptcha-response")  ;
 }
  
 logger.debug("challenge: " + recaptcha_challenge);
 logger.debug("response: " + recaptcha_response);
 logger.debug("remoteAddr: " + remoteAddr);
  
 // Proceed with the remaining filters
 chain.doFilter(req, res);
}

public String getRecaptcha_response() {
 return recaptcha_response;
}

public void setRecaptcha_response(String recaptchaResponse) {
 recaptcha_response = recaptchaResponse;
}

public String getRecaptcha_challenge() {
 return recaptcha_challenge;
}

public void setRecaptcha_challenge(String recaptchaChallenge) {
 recaptcha_challenge = recaptchaChallenge;
}

public String getRemoteAddr() {
 return remoteAddr;
}

public void setRemoteAddr(String remoteAddr) {
 this.remoteAddr = remoteAddr;
}
}