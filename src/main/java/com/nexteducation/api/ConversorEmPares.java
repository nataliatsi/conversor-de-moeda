package com.nexteducation.api;

import com.google.gson.annotations.SerializedName;

public class ConversorEmPares {
    @SerializedName("base_code")
    private String moedaOrigem;
    @SerializedName("target_code")
    private String moedaDestino;
    @SerializedName("conversion_rate")
    private double taxaCambio;
    @SerializedName("conversion_result")
    private double valorConvertido;

    public String getMoedaOrigem(){
        return moedaOrigem;
    }

    public String getMoedaDestino(){
        return moedaDestino;
    }

    public double getTaxaDeCambio() {
        return taxaCambio;
    }

    public double getResultadoConversao() {
        return valorConvertido;
    }

}