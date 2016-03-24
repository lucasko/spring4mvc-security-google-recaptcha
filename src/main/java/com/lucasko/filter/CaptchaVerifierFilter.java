package com.lucasko.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

public class CaptchaVerifierFilter extends OncePerRequestFilter {
private Boolean useProxy = false;
private String proxyPort;
private String proxyHost;
private String failureUrl;
private CaptchaCaptureFilter captchaCaptureFilter;
private String privateKey;
 
private SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

@Override
public void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
  FilterChain chain) throws IOException, ServletException {

  
 if (captchaCaptureFilter.getRecaptcha_response() != null) {
	 String gRecaptchaResponse = 
	 captchaCaptureFilter.getRecaptcha_response() ;
     System.out.println(gRecaptchaResponse);
     boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
     System.out.println(verify);

  if (!verify) {
    
   failureHandler.setDefaultFailureUrl(failureUrl);
   failureHandler.onAuthenticationFailure(req, res, new BadCredentialsException("Captcha invalid!"));

  }
   resetCaptchaFields();
 }
 chain.doFilter(req, res);
}

// Reset Captcha fields
public void resetCaptchaFields() {
 captchaCaptureFilter.setRemoteAddr(null);
 captchaCaptureFilter.setRecaptcha_challenge(null);
 captchaCaptureFilter.setRecaptcha_response(null);
}
 
public Boolean getUseProxy() {
 return useProxy;
}

public void setUseProxy(Boolean useProxy) {
 this.useProxy = useProxy;
}

public String getProxyPort() {
 return proxyPort;
}

public void setProxyPort(String proxyPort) {
 this.proxyPort = proxyPort;
}

public String getProxyHost() {
 return proxyHost;
}

public void setProxyHost(String proxyHost) {
 this.proxyHost = proxyHost;
}

public String getFailureUrl() {
 return failureUrl;
}

public void setFailureUrl(String failureUrl) {
 this.failureUrl = failureUrl;
}

public CaptchaCaptureFilter getCaptchaCaptureFilter() {
 return captchaCaptureFilter;
}

public void setCaptchaCaptureFilter(CaptchaCaptureFilter captchaCaptureFilter) {
 this.captchaCaptureFilter = captchaCaptureFilter;
}

public String getPrivateKey() {
 return privateKey;
}

public void setPrivateKey(String privateKey) {
 this.privateKey = privateKey;
}
}