package br.com.fiap.petwell.repository;

import android.app.Activity;
import android.util.Base64;
import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.petwell.bean.Alimentador;
import br.com.fiap.petwell.bean.AppNavDomain;
import br.com.fiap.petwell.util.base64.Base64Util;
import br.com.fiap.petwell.util.hash.HashUtil;
import br.com.fiap.petwell.util.url.UrlUtil;

public abstract class FeederRegisterRepository {

    public static String register(Activity activity, String nome, int devCode) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000*10);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000*20);
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

            String hash = new Base64Util().encode(HashUtil.getHash(activity));

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Authorization", "Basic " + hash);
            headers.add("Content-Type", "application/json");

            Alimentador alimentador = new Alimentador();
            alimentador.setNome(nome);
            alimentador.setDevCode(devCode);

            HttpEntity<Alimentador> request = new HttpEntity<Alimentador>(alimentador, headers);
            String json = restTemplate.postForObject(UrlUtil.getUrlFromAppNav(activity, AppNavDomain.FEEDER_REGISTER), request, String.class);
            Log.i("json", json);
            return json;

        } catch (RestClientException e) {
            return null;
        }
    }
}