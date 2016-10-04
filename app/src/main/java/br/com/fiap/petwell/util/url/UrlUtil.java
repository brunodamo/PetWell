package br.com.fiap.petwell.util.url;

import android.app.Activity;

import br.com.fiap.petwell.activity.AppNavActivity;
import br.com.fiap.petwell.activity.LoginActivity;
import br.com.fiap.petwell.activity.RegistrationActivity;
import br.com.fiap.petwell.bean.AppNavDomain;

public abstract class UrlUtil {

    private static String url;
    private static final String CONNECTION_URL = "http://10.0.2.2:8181/ApiPetWell/rest/";

    public static String getUrl(Activity activity){
        if(activity instanceof LoginActivity){
            url = CONNECTION_URL+"usuario/login";
        }else if (activity instanceof RegistrationActivity){
            url = CONNECTION_URL+"usuario";
        }
        return url;
    }

    public static String getUrlFromAppNav(Activity activity, AppNavDomain action){
        if (action == AppNavDomain.FEEDER_REGISTER){
            url = CONNECTION_URL+"alimentador";
        }else if (action == AppNavDomain.LOGOUT){
            url = CONNECTION_URL+"usuario/logout";
        }
        return url;
    }

    public static String getUrlFromAppNav(Activity activity, AppNavDomain action, int devCode){
        if (action == AppNavDomain.FEED){
            url = CONNECTION_URL+"alimentador/alimentar/"+devCode;
        }
        return url;
    }

}
