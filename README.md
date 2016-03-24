Package Explorer
-----------------------------
![image](https://github.com/lucas0x6b6f/spring4mvc-security-google-recaptcha/blob/master/src/main/resources/package-explorer.png)


Before Starting
------------------------------
1. Let's register recaptcha for site key and secret key

[https://www.google.com/recaptcha/intro/index.html](https://www.google.com/recaptcha/intro/index.html)

2. modify spring-securit.xml for private key (secret key).

		p:privateKey="YOUR_SECRET_KEY" />
	
3. modify VerifyRecaptcha.java for secre key and site key.
```JAVA
		public static final String SECRET_KEY = "YOUR_SECRET_KEY"; 
		public static final String SITE_KEY = "YOUR_SITE_KEY";
```
4. modify login.jsp for data-sitekey (site key)
```HTML
		<div class="g-recaptcha"
		data-sitekey="YOUR_SITE_KEY"
		style="margin: 0px auto;">
		</div>
```

Run Project on Server
-----------------------------------------
![image](https://github.com/lucas0x6b6f/spring4mvc-security-google-recaptcha/blob/master/src/main/resources/recaptcha-login-page.png)



