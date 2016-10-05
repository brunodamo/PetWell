package br.com.fiap.petwell.repository;

import android.app.Activity;
import android.util.Log;
import android.webkit.URLUtil;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import br.com.fiap.petwell.bean.Alimentador;
import br.com.fiap.petwell.bean.AppNavDomain;
import br.com.fiap.petwell.bean.StatusResponse;
import br.com.fiap.petwell.util.base64.Base64Util;
import br.com.fiap.petwell.util.hash.HashUtil;
import br.com.fiap.petwell.util.url.UrlUtil;

public abstract class FeedRepository {

    public static String register(Activity activity, int devCode) {
        try {
            RestTemplate restTemplate = new RestTemplate();
           ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000*10);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000*20);
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

            String hash = new Base64Util().encode(HashUtil.getHash(activity));

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Authorization", "Basic " + hash);
            headers.add("Content-Type", "application/json");

            HttpEntity<String> request = new HttpEntity<String>(null, headers);

            HttpEntity<String> json = restTemplate.exchange(UrlUtil.getUrlFromAppNav(activity, AppNavDomain.FEED,devCode), HttpMethod.POST, request, String.class);
            Log.i("json", json.getBody());
            return json.getBody();
        } catch (RestClientException e) {
            return null;
        }
    }
}