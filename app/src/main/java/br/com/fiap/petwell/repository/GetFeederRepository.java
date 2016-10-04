package br.com.fiap.petwell.repository;

import android.app.Activity;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import br.com.fiap.petwell.bean.Alimentador;
import br.com.fiap.petwell.bean.AppNavDomain;
import br.com.fiap.petwell.util.url.UrlUtil;

public abstract class GetFeederRepository {

    public static String getFeeders(Activity activity){
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000*10);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000*20);
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            List<Alimentador> alimentadores = restTemplate.getForObject(UrlUtil.getUrlFromAppNav(activity, AppNavDomain.FEEDER_REGISTER)+"/alimentador/", List<Alimentador>);
            String url = UrlUtil.getUrl(activity);
            String json = restTemplate.postForObject(url, alimentador, String.class);
            return json;
        } catch (RestClientException e) {
            return null;
        }
    }
}