package br.com.fiap.petwell.repository;

import android.app.Activity;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.petwell.bean.Usuario;
import br.com.fiap.petwell.util.url.UrlUtil;

public abstract class UserRegisterRepository {

    public static String register(Activity activity, String nome, String email, String senha) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000*10);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000*20);
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            String url = UrlUtil.getUrl(activity);
            String json = restTemplate.postForObject(url, usuario, String.class);
            return json;
        } catch (RestClientException e) {
            return null;
        }
    }
}