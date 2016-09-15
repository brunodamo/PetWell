package br.com.fiap.petwell.util.hash;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public abstract class HashUtil {

    public static void hashClear(Activity activity){
        Context context = activity;
        SharedPreferences sharedPreferences = context.getSharedPreferences("Hash",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Hash", "NO_HASH_FOUND");
        editor.commit();
    }

    public static String getHash(Activity activity){
        Context context = activity;
        SharedPreferences sharedPreferences = context.getSharedPreferences("Hash",Context.MODE_PRIVATE);
        String hash = sharedPreferences.getString("Hash", "NO_HASH_FOUND");
        return hash;
    }

    public static void setHash (Activity activity, String hash) {
        Context context = activity;
        SharedPreferences sharedPreferences = context.getSharedPreferences("Hash",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Hash", hash);
        editor.commit();
    }

}
