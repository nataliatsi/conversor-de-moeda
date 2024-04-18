package com.nexteducation;

import java.util.Scanner;

import com.nexteducation.api.Conversor;
import com.nexteducation.api.ConversorEmPares;
import com.nexteducation.util.GeradorDeArquivo;
import com.nexteducation.util.logs.RegistroDeLogs;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entrada;

        String moedaOrigem;
        String moedaDestino;
        double valor;

        Conversor conversor = new Conversor();
        List<ConversorEmPares> conversoes = new ArrayList<>();

        do {
            System.out.print("Digite a moeda de origem (3 caracteres): ");
            moedaOrigem = scanner.nextLine().toUpperCase();

            System.out.print("Digite a moeda de destino (3 caracteres): ");
            moedaDestino = scanner.nextLine().toUpperCase();

            System.out.print("Digite a valor: ");
            valor = scanner.nextDouble();

            scanner.nextLine();

            ConversorEmPares conversao = conversor.converter(moedaOrigem, moedaDestino, valor);
            conversoes.add(conversao);

            RegistroDeLogs.registrarConversoes(conversoes);

            System.out.print("Deseja fazer outra conversão? (1 - Sim, 0 - Não): ");
            entrada = scanner.nextInt();

            scanner.nextLine();

        } while (entrada != 0);

        scanner.close();
        System.out.println("Encerrando programa...");

        GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();

        try {
            geradorDeArquivo.salvarListaJson(conversoes);
            System.out.println("Conversões salvas em arquivo JSON com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar as conversões em arquivo JSON: " + e.getMessage());
        }
    }
}