package br.com.fiap.petwell.repository;

import android.app.Activity;
import android.webkit.URLUtil;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import br.com.fiap.petwell.bean.Alimentador;
import br.com.fiap.petwell.bean.AppNavDomain;
import br.com.fiap.petwell.bean.StatusResponse;
import br.com.fiap.petwell.util.url.UrlUtil;

public abstract class FeedRepository {

    public static String register(Activity activity, int devCode) {
        try {
            RestTemplate restTemplate = new RestTemplate();
           ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000*10);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000*20);
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            String json = restTemplate.postForObject(UrlUtil.getUrlFromAppNav(activity,AppNavDomain.FEED,devCode), null, String.class);
            return json;
        } catch (RestClientException e) {
            return null;
        }
    }
}