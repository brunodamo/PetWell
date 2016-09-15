package br.com.fiap.petwell.repository;

import android.app.Activity;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.petwell.util.hash.HashUtil;
import br.com.fiap.petwell.util.url.UrlUtil;

public class LogoutRepository {

    public static String logout(Activity activity){
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000 * 10);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000 * 20);
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            String url = UrlUtil.getUrl(activity);
            String json = restTemplate.postForObject(url, HashUtil.getHash(activity), String.class);
            return json;
        } catch (RestClientException e) {
            return null;
        }
    }
}
