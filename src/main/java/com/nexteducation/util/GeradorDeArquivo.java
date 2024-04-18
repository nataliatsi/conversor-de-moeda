package com.nexteducation.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nexteducation.api.ConversorEmPares;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GeradorDeArquivo {
    public void salvarListaJson(List<ConversorEmPares> conversoes) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Date dataAtual = new Date();

        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String nomeArquivo = "src/main/java/com/nexteducation/util/historico/" + formatoData.format(dataAtual) + ".json";

        File diretorio = new File("src/main/java/com/nexteducation/util/historico");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        FileWriter escrita = new FileWriter(nomeArquivo);

        gson.toJson(conversoes, escrita);

        escrita.close();
    }
}
