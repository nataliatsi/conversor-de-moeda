package com.nexteducation.util.logs;

import com.nexteducation.api.ConversorEmPares;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegistroDeLogs {

    private static final String LOG_FILE_PATH = "src/main/java/com/nexteducation/util/logs/conversoes.log";

    public static void registrarConversoes(List<ConversorEmPares> conversoes) {
        try (PrintWriter writer = new PrintWriter(LOG_FILE_PATH)) {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            writer.println("Registros de conversões realizadas em: " + agora.format(formatter));
            writer.println();

            for (ConversorEmPares conversao : conversoes) {
                writer.println("Moeda de origem: " + conversao.getMoedaOrigem());
                writer.println("Moeda de destino: " + conversao.getMoedaDestino());
                writer.println("Taxa de câmbio: " + conversao.getTaxaDeCambio());
                writer.println("Valor convertido: " + conversao.getResultadoConversao());
                writer.println();
            }

            writer.flush();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}
