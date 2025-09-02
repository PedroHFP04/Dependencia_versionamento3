package br.inatel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilmesJson{
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvarFilmesEmJson(List<Filme> filmes, String nomeArquivo) {
        String json = gson.toJson(filmes);
        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            fw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
