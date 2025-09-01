package br.inatel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String titulo;
    private int ano;
    private String genero;
    private String diretor;
    static List<Filme> filmes;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Filme( String titulo, int ano, String genero, String diretor) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.diretor = diretor;
        filmes = new ArrayList<Filme>();
    }


    public void salvarFilmesEmJson(List<Filme> filmes, String nomeArquivo) {
        String json = gson.toJson(filmes);

        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            fw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFilme(Filme filme) {
        filmes.add(filme);
    }

    public void CriarFilme() {
        Filme filme = new Filme("Vingadores 3",2010,"Ação","Carlos Alberto");
    }


}
