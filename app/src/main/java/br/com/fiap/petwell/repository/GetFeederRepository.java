package br.com.fiap.petwell.repository;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import br.com.fiap.petwell.bean.Alimentador;
import br.com.fiap.petwell.bean.AppNavDomain;
import br.com.fiap.petwell.util.base64.Base64Util;
import br.com.fiap.petwell.util.hash.HashUtil;
import br.com.fiap.petwell.util.url.UrlUtil;

public abstract class GetFeederRepository {

    public static String getFeeders(Activity activity){
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000*10);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000*20);
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

            String hash = new Base64Util().encode(HashUtil.getHash(activity));

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Authorization", "Basic " + hash);
            headers.add("Content-Type", "application/json");

            HttpEntity<String> request = new HttpEntity<String>(null, headers);

            HttpEntity<String> json = restTemplate.exchange(UrlUtil.getUrlFromAppNav(activity, AppNavDomain.FEEDER_REGISTER), HttpMethod.GET, request, String.class);
            return json.getBody();
        } catch (RestClientException e) {
            return null;
        }
    }
}