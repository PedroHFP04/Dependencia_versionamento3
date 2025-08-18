package br.inatel;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Filme filme = new Filme("Vingadores",2010,"Ação");

        System.out.println(gson.toJson(filme));

    }
}