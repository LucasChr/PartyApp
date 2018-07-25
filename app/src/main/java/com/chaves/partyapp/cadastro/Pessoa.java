package com.chaves.partyapp.cadastro;

public class Pessoa {

    private Long id;
    private String nome;
    private Integer rg;
    private Integer cpf;
    private String foto;

    public static final String ID = "_id";
    public static final String NOME = "p_nome";
    public static final String RG = "p_rg";
    public static final String CPF = "p_cpf";
    public static final String FOTO = "p_foto";

    public static final String TABELA = "pessoas";
    public static final String[] COLUNAS = {ID, NOME, RG, CPF, FOTO};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public static String getID() {
        return ID;
    }

    public static String getNOME() {
        return NOME;
    }

    public static String getRG() {
        return RG;
    }

    public static String getCPF() {
        return CPF;
    }

    public static String getFOTO() {
        return FOTO;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String[] getCOLUNAS() {
        return COLUNAS;
    }
}
