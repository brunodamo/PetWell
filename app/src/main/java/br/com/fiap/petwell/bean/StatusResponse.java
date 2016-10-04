package br.com.fiap.petwell.bean;

public class StatusResponse {

    private boolean status;
    private String hashAcesso;

    public String getHashAcesso() {
        return hashAcesso;
    }

    public void setHashAcesso(String hashAcesso) {
        this.hashAcesso = hashAcesso;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
