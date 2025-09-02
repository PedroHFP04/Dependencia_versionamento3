package br.inatel;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmes {

    private static List<Filme> filmes = new ArrayList<>();


    public static void addFilmeLista(Filme filme) {
        filmes.add(filme);
    }

    public static List<Filme> getFilmes() {
        return filmes;
    }

    public static void limparListaFilmes() {
        filmes.clear();
    }
}
