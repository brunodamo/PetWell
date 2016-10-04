package br.com.fiap.petwell.util.hash;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public abstract class HashUtil {

    public static void hashClear(Activity activity){
        Context context = activity;
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_HASH",Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("PREF_HASH", "NO_HASH_FOUND").commit();
    }

    public static String getHash(Activity activity){
        Context context = activity;
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_HASH", Context.MODE_PRIVATE);
        String hash = sharedPreferences.getString("PREF_HASH", "NO_HASH_FOUND");
        return hash;
    }

    public static void setHash (Activity activity, String hash) {
        Context context = activity;
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_HASH",Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("PREF_HASH", hash).commit();
    }

}
