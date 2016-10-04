package br.com.fiap.petwell.util.alert;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;

import br.com.fiap.petwell.activity.LoginActivity;
import br.  com.fiap.petwell.activity.R;

public abstract class AlertUtil {

    public static void getOKRegisterDialog(Activity activity){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(R.string.msgRegisterOK);
        alerta.setTitle(R.string.msgRegisterOKTitle);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent toLoginAct = new Intent(((Dialog) dialog).getContext(), LoginActivity.class);
                        ((Dialog) dialog).getContext().startActivity(toLoginAct);
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }

    public static void getOKFeederRegisterDialog(Activity activity){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(R.string.msgFeederOKRegister);
        alerta.setTitle(R.string.msgFeederOKRegisterTitle);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }

    public static void getFailRegisterDialog(Activity activity){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(R.string.msgRegisterFail);
        alerta.setTitle(R.string.msgRegisterFailTitle);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }

    public static void getFailLoginDialog(Activity activity){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(R.string.msgLoginFail);
        alerta.setTitle(R.string.msgLoginTitle);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }
    public static void getConnectionTimeoutDialog(Activity activity){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(R.string.msgConnTimeout);
        alerta.setTitle(R.string.msgConnTimeoutTitle);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }
    public static void getFailLogoutDialog(Activity activity){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(R.string.msgLogoutFail);
        alerta.setTitle(R.string.msgLogoutFailTitle);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }
    public static void getOKFeedDialog(Activity activity){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(R.string.msgFeedOK);
        alerta.setTitle(R.string.msgFeedOKTitle);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }
    public static void getFailFeedDialog(Activity activity){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(R.string.msgFeedFail);
        alerta.setTitle(R.string.msgFeedFailTitle);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }

    public static void ActionlessDialogBuilder(Activity activity, int title, int message){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setMessage(message);
        alerta.setTitle(title);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alerta.create().show();
    }

}
