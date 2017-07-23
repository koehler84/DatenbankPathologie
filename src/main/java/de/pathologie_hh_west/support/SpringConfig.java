package de.pathologie_hh_west.support;

import de.pathologie_hh_west.ui.util.SpringFXMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ResourceBundle;

/**
 * Created by eike on 10.07.2017.
 */
@Configuration
public class SpringConfig {

	@Bean
	public ResourceBundle resourceBundle() {
		return ResourceBundle.getBundle("ui.resourcebundles.Bundle");
	}
	
	@Bean
	@Scope("prototype")
	public Logger logger(InjectionPoint injectionPoint){
		return LoggerFactory.getLogger(injectionPoint.getField().getDeclaringClass());
	}
}
