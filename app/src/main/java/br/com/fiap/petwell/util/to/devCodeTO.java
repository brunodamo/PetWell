package br.com.fiap.petwell.util.to;


public abstract class DevCodeTO {

    private static int devCode;

    public static int getDevCode() {
        return devCode;
    }

    public static void setDevCode(int devCode) {
        DevCodeTO.devCode = devCode;
    }


}
