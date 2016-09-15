package br.com.fiap.petwell.util.url;

import android.app.Activity;

import br.com.fiap.petwell.activity.AppNavActivity;
import br.com.fiap.petwell.activity.LoginActivity;
import br.com.fiap.petwell.activity.RegistrationActivity;

public abstract class UrlUtil {

    private static String url;

    public static String getUrl(Activity activity){
        if(activity instanceof LoginActivity){
            url = "http:///10.0.2.2:8181/ApiPetWell/rest/usuario/login";
        }else if (activity instanceof RegistrationActivity){
            url = "http:///10.0.2.2:8181/ApiPetWell/rest/usuario";
        }else if (activity instanceof AppNavActivity){
            url = "http:///10.0.2.2:8181/ApiPetWell/rest/usuario/logout";
        }
        return url;
    }
}
