package springStudy.bean;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * ResourceBundle을 keySet 단위로 핸들링하기 위해 선언
 * 
 * @author TigMonkey
 */
@Component
public class ExposedResourceMessageBundleSource extends ReloadableResourceBundleMessageSource {
	
	/**
	 * 파일의 Properties를 반환
	 * 
	 * @author TigMonkey
	 * @param locale
	 * @return
	 */
    public Properties getMessages(Locale locale){
        return getMergedProperties(locale).getProperties();
    }
    
}