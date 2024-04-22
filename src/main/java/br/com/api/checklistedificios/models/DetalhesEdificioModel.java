package br.com.api.checklistedificios.models;

import jakarta.persistence.*;


import java.io.Serializable;

public class DetalhesEdificioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private EdificioModel edificioModel;
    private String nome_do_andar;
    private int quantidade_de_andares;
    private int quantidade_de_garagens;
    private int quantidade_de_salao_de_festa;
    private int quantidade_de_guaritas;
    private int quantidade_de_terraços;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EdificioModel getEdificioModel() {
        return edificioModel;
    }

    public void setEdificioModel(EdificioModel edificioModel) {
        this.edificioModel = edificioModel;
    }

    public String getNome_do_andar() {
        return nome_do_andar;
    }

    public void setNome_do_andar(String nome_do_andar) {
        this.nome_do_andar = nome_do_andar;
    }

    public int getQuantidade_de_andares() {
        return quantidade_de_andares;
    }

    public void setQuantidade_de_andares(int quantidade_de_andares) {
        this.quantidade_de_andares = quantidade_de_andares;
    }

    public int getQuantidade_de_garagens() {
        return quantidade_de_garagens;
    }

    public void setQuantidade_de_garagens(int quantidade_de_garagens) {
        this.quantidade_de_garagens = quantidade_de_garagens;
    }

    public int getQuantidade_de_salao_de_festa() {
        return quantidade_de_salao_de_festa;
    }

    public void setQuantidade_de_salao_de_festa(int quantidade_de_salao_de_festa) {
        this.quantidade_de_salao_de_festa = quantidade_de_salao_de_festa;
    }

    public int getQuantidade_de_guaritas() {
        return quantidade_de_guaritas;
    }

    public void setQuantidade_de_guaritas(int quantidade_de_guaritas) {
        this.quantidade_de_guaritas = quantidade_de_guaritas;
    }

    public int getQuantidade_de_terraços() {
        return quantidade_de_terraços;
    }

    public void setQuantidade_de_terraços(int quantidade_de_terraços) {
        this.quantidade_de_terraços = quantidade_de_terraços;
    }
}


