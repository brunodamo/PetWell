package br.com.fiap.petwell.util.base64;

import android.util.Base64;

public class Base64Util {

    public String encode(String hash){
        byte[] plainCredsBytes = hash.getBytes();
        byte[] base64CredsBytes = Base64.encode(plainCredsBytes, Base64.DEFAULT);
        return new String(base64CredsBytes);
    }

}
