package br.com.fiap.petwell.bean;

public class Alimentador {

    private int codigo;

    private Usuario usuario;

    private Configuracao configuracao;

    public Alimentador() {
    }

    public Alimentador(int codigo, Usuario usuario, Configuracao configuracao) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.configuracao = configuracao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }
}
