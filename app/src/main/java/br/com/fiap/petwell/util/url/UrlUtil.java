package br.com.fiap.petwell.util.url;

import android.app.Activity;

import br.com.fiap.petwell.activity.AppNavActivity;
import br.com.fiap.petwell.activity.LoginActivity;
import br.com.fiap.petwell.activity.RegistrationActivity;

public abstract class UrlUtil {

    private static String url;
    private final String CONNECTION_URL = "http:///10.0.2.2:8181/ApiPetWell/rest/";

    public static String getUrl(Activity activity){
        if(activity instanceof LoginActivity){
            url = CONNECTION_URL+"usuario/login";
        }else if (activity instanceof RegistrationActivity){
            url = CONNECTION_URL+"usuario";
        }else if (activity instanceof AppNavActivity){
            url = CONNECTION_URL+"usuario/logout";
        }
        return url;
    }
}
