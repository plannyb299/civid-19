package com.flightech.covid19;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


@Configuration
public class PdfConfiguration {

        @Bean
        public ClassLoaderTemplateResolver emailTemplateResolver(){
            ClassLoaderTemplateResolver emailTemplateResolver=new ClassLoaderTemplateResolver();
            emailTemplateResolver.setPrefix("templates/");
            emailTemplateResolver.setTemplateMode("HTML5");
            emailTemplateResolver.setSuffix(".html");
            emailTemplateResolver.setTemplateMode("XHTML");
            emailTemplateResolver.setCharacterEncoding("UTF-8");
            emailTemplateResolver.setOrder(1);
            return emailTemplateResolver;

    }

}
