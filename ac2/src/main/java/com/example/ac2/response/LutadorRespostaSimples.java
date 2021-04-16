package com.example.ac2.response;

import com.example.ac2.dominio.Lutador;

public class LutadorRespostaSimples {
    private String nome;
    private Double forcaGolpe;

    public LutadorRespostaSimples(Lutador lutador) {
        this.nome = lutador.getNome();
        this.forcaGolpe = lutador.getForcaGolpe();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getForcaGolpe() {
        return forcaGolpe;
    }

    public void setForcaGolpe(Double forcaGolpe) {
        this.forcaGolpe = forcaGolpe;
    }
}
