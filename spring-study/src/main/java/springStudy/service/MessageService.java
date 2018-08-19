package springStudy.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import springStudy.bean.ExposedResourceMessageBundleSource;

/**
 * MessageService
 * 
 * @author TigMonkey
 */
@Service
public class MessageService{

	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 파일의 properties를  Map으로 반환
	 * 
	 * @author TigMonkey
	 * @return
	 */
	private Map<String,String> getMessages(){
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		ExposedResourceMessageBundleSource exposedResourceMessageBundleSource 
			= (ExposedResourceMessageBundleSource) messageSource;
		
        Properties properties = exposedResourceMessageBundleSource.getMessages(httpServletRequest.getLocale());
        
        Map<String,String> messagesMap = new HashMap<String,String>();
        for(Map.Entry<Object,Object> entry: properties.entrySet()){
            if(entry.getKey() != null && entry.getValue() != null) {
                messagesMap.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return messagesMap;
    }
	
	/**
	 * 특정 키값을 포함하는 메시지 entry Map을 반환
	 * 
	 * @author TigMonkey
	 * @param specificPrefixKey
	 * @return
	 */
	public Map<String, String> getSpecificMessages(String specificPrefixKey) {
		
		Map<String, String> allPropertiesMap = getMessages();
		Map<String, String> retMap = new HashMap<String, String>();
		Iterator<String> iter = allPropertiesMap.keySet().iterator();
		
		Pattern pattern = Pattern.compile("^"+specificPrefixKey);
		Matcher matcher = null;
		
		while(iter.hasNext()) {
			String key = iter.next();
			
			matcher = pattern.matcher(key);
			
			if(matcher.find()) {
				retMap.put(key, allPropertiesMap.get(key));
			}		
		}
		
		return retMap;
	}
	
}
