package br.inatel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Filme> filmes = Arrays.asList(filme, filme2);

        String json = gson.toJson(filmes);

        try {
            FileWriter fw = new FileWriter("filmes.json");
            fw.write(json);
            System.out.println("Arquivo filmes criado com sucesso!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}