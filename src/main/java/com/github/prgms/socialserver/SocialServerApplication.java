package com.github.prgms.socialserver;

import com.sun.xml.internal.ws.developer.Serialization;
import jdk.jfr.BooleanFlag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SocialServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialServerApplication.class, args);
	}

}
