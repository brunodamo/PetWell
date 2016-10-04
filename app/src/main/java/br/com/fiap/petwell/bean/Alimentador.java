package br.com.fiap.petwell.bean;

public class Alimentador {

    private int codigo;

    private String nome;

    private Usuario usuario;

    private Configuracao configuracao;

    private int devCode;

    public Alimentador() {
    }

    public Alimentador(int codigo, String nome, Usuario usuario, Configuracao configuracao, int devCode) {
        this.codigo = codigo;
        this.nome = nome;
        this.usuario = usuario;
        this.configuracao = configuracao;
        this.devCode = devCode;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getDevCode() {
        return devCode;
    }

    public void setDevCode(int devCode) {
        this.devCode = devCode;
    }

    @Override
    public String toString(){
        return this.nome;
    }

}
