package com.flightech.covid19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Covid19Application {


    //private static final Logger LOGGER=LoggerFactory.getLogger(FirstAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FirstAppApplication.class, args);
        //LOGGER.info("--Simple log statement is running with inputs now");
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelmapper =new ModelMapper();
        modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelmapper;
    }

//	@Bean
//	@Scope("prototype")
//	Logger logger(InjectionPoint injectionPoint){
//	    return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
//
//	}

}
