package com.nexteducation.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Conversor {
    private String apiKey;

    public Conversor() {
        loadApiKey();
    }

    private void loadApiKey() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
            apiKey = properties.getProperty("api.key");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar a chave da API do arquivo de propriedades.", e);
        }
    }

    public ConversorEmPares converter(String moedaOrigem, String moedaDestino, double valor) {
        String urlApi = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaOrigem + "/" + moedaDestino
                + "/" + valor;

        try {
            URI uri = URI.create(urlApi);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro ao acessar a API: " + response.statusCode());
            }

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            ConversorEmPares conversorEmPares = gson.fromJson(response.body(), ConversorEmPares.class);

            System.out.println("---------------------------");
            System.out.printf("%-18s: %s\n", "Moeda de origem", conversorEmPares.getMoedaOrigem());
            System.out.printf("%-18s: %s\n", "Moeda de destino", conversorEmPares.getMoedaDestino());
            System.out.printf("%-18s: %.2f\n", "Quantidade", valor);
            System.out.printf("%-18s: %.4f\n", "Taxa de câmbio", conversorEmPares.getTaxaDeCambio());
            System.out.printf("%-18s: %.2f\n", "Valor convertido", conversorEmPares.getResultadoConversao());
            System.out.println("---------------------------");

            return conversorEmPares;

        } catch (IOException e) {
            throw new RuntimeException("Erro de IO ao acessar a API.", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("A solicitação foi interrompida.", e);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao fazer a conversão.", e);
        }
    }
}
