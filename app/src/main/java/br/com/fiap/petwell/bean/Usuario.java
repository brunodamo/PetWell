package br.com.fiap.petwell.bean;


public class Usuario {

    private int codigo;
    private String nome;
    private String email;
    private Alimentador alimentador;
    private String senha;

    public Usuario() {
    }

    public Usuario(int codigo, String nome, String email, Alimentador alimentador, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.alimentador = alimentador;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Alimentador getAlimentador() {
        return alimentador;
    }

    public void setAlimentador(Alimentador alimentador) {
        this.alimentador = alimentador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
