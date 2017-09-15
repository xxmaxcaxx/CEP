package br.com.fernandohenryhruschka.cep;

import com.google.gson.annotations.SerializedName;

/**
 * Created by logonrm on 15/09/2017.
 */

public class CEP {
    @SerializedName(value = "tipoDeLogradouro")
    private String tipoDeLogradouro;
    @SerializedName(value = "logradouro" )
    private String logradouro;
    @SerializedName(value = "bairro")
    private String bairro;
    @SerializedName(value = "cidade")
    private String cidade;
    @SerializedName(value = "estado")
    private String estado;

    public String getTipoDeLogradouro() {
        return tipoDeLogradouro;
    }

    public void setTipoDeLogradouro(String tipoDeLogradouro) {
        this.tipoDeLogradouro = tipoDeLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
