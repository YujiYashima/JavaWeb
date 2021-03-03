package br.com.projetoempresa.model;

public class Pessoa {

    //Atributos da Class
    private int idPessoa;
    private String nomePessoa;
    private String telefonePessoa;

    //Construtores Vazio e Cheio
    public Pessoa() {
    }

    public Pessoa(int idPessoa, String nomePessoa, String telefonePessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.telefonePessoa = telefonePessoa;
    }

    //Metodo acessores Get e Set
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

}
