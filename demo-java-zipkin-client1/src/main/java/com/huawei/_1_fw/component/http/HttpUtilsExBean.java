package com.huawei._1_fw.component.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpUtilsExBean {
	// #region Fields

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	// #endregion

	// #region postByTemplate

	public <T> T postByTemplate(String strUrl, Object oPostParam, Class<T> oResponseClazz) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<Object> oRequest = new HttpEntity<Object>(oPostParam, headers);
		return restTemplate.postForObject(strUrl, oRequest, oResponseClazz);
	}

	// #endregion

}
