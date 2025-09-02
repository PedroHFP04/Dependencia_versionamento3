package br.inatel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filme {
    private String titulo;
    private int ano;
    private String genero;
    private String diretor;
    private static List<Filme> filmes = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Filme( String titulo, int ano, String genero, String diretor) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.diretor = diretor;
        filmes.add(this);
    }

    public static List<Filme> getFilmes() {
        return filmes;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do filme: ");
        String titulo = sc.nextLine();
        System.out.println("Digite o ano do filme: ");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o genero do filme: ");
        String genero = sc.nextLine();
        System.out.println("Digite o diretor do filme: ");
        String diretor = sc.nextLine();
        Filme filme = new Filme(titulo, ano, genero, diretor);
    }


}
