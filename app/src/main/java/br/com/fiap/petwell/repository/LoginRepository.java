package br.com.fiap.petwell.repository;

import android.app.Activity;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.petwell.bean.Login;
import br.com.fiap.petwell.util.url.UrlUtil;

public abstract class LoginRepository {

    public static String login(Activity activity, String email, String senha){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000*10);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000*20);
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            Login login = new Login(email, senha);
            String url = UrlUtil.getUrl(activity);
            String json = restTemplate.postForObject(url, login, String.class);
            return json;
        }catch (RestClientException e){
            return null;
        }

    }
}
