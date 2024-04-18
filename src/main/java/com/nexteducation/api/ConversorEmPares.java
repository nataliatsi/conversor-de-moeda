package com.nexteducation.api;

public class ConversorEmPares {
    private String base_code, target_code;
    private double conversion_rate;
    private double conversion_result;

    public String getMoedaOrigem(){
        return base_code;
    }

    public String getMoedaDestino(){
        return target_code;
    }

    public double getTaxaConversao() {
        return conversion_rate;
    }

    public double getResultadoConversao() {
        return conversion_result;
    }

}