package springStudy.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.mustache.jmustache.LocalizationMessageInterceptor;

import springStudy.bean.ExposedResourceMessageBundleSource;

/**
 * 국제화 서비스를 위한 Configuration
 * 
 * @author TigMonkey
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class I18nConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Bean : LocaleResovler 
	 * 
	 * @author TigMonkey
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		
		// 쿠키
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieName("lang");
		
		return resolver;
	}

	/**
	 * Method Override : addInterceptors
	 * 
	 * @author TigMonkey
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		
		registry.addInterceptor(localeChangeInterceptor);
		registry.addInterceptor(getLocalizationMessageInterceptor());
	}
	
	/**
	 * Bean : MessageSource
	 * 
	 * @author TigMonkey
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		
		ExposedResourceMessageBundleSource messageSource = new ExposedResourceMessageBundleSource();
		messageSource.setBasename("classpath:/i18n/messages");
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
	
	/**
	 * Bean : LocalizationMessageInterceptor
	 * 
	 * @author TigMonkey
	 * @return
	 */
	@Bean
    public LocalizationMessageInterceptor getLocalizationMessageInterceptor() {
        LocalizationMessageInterceptor lmi = new LocalizationMessageInterceptor();
        lmi.setLocaleResolver(localeResolver());
        lmi.setMessageSource(messageSource());
        lmi.setMessageKey("msg");
        
        return lmi;
    }
}