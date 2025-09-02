package br.inatel;
import java.util.Scanner;

public class Filme {
    private String titulo;
    private int ano;
    private String genero;
    private String diretor;

    public Filme( String titulo, int ano, String genero, String diretor) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.diretor = diretor;
        ListaFilmes.addFilmeLista(this);
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

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }
}
