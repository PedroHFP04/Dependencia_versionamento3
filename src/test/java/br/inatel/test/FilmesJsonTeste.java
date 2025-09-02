package br.inatel.test;

import br.inatel.Filme;
import br.inatel.FilmesJson;
import br.inatel.ListaFilmes;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class FilmesJsonTeste {

    @Test // testa se eu consigo criar um arquivo em json com a minha lista de filmes
    public void testeArquivoJson(){
        Filme filme = new Filme("Titulo", 2002, "genero", "diretor");
        String nomeArquivo = "teste_filmes.json";

        FilmesJson.salvarFilmesEmJson(ListaFilmes.getFilmes(), nomeArquivo);

        File arquivo = new File(nomeArquivo);

        assertTrue(arquivo.exists());
        arquivo.delete();
    }
    @Test // testa se o arquivo é sobrescrito
    public void testeSobrescreverArquivo() throws IOException {
        String nomeArquivo = "filmes_sobrescreve.json";

        // primeira gravação
        new Filme("A", 2000, "Gen", "Dir");
        FilmesJson.salvarFilmesEmJson(ListaFilmes.getFilmes(), nomeArquivo);

        // segunda gravação
        ListaFilmes.getFilmes().clear();
        new Filme("B", 2001, "Gen", "Dir");
        FilmesJson.salvarFilmesEmJson(ListaFilmes.getFilmes(), nomeArquivo);

        String conteudo = Files.readString(new File(nomeArquivo).toPath());
        assertTrue(conteudo.contains("B"));
        assertFalse(conteudo.contains("A"));

        new File(nomeArquivo).delete();
    }

    @Test // testa se o conteudo do arquivo criado é igual ao da lista
    public void testeConteudoArquivoContemTitulo() throws IOException {
        new Filme("Titulo", 2002, "Genero", "Diretor");
        String nomeArquivo = "filmes_conteudo.json";
        FilmesJson.salvarFilmesEmJson(ListaFilmes.getFilmes(), nomeArquivo);

        String conteudo = Files.readString(new File(nomeArquivo).toPath());
        assertTrue(conteudo.contains("Titulo"));

        new File(nomeArquivo).delete();
    }

    @Test // testa a criacao de um arquivo vazio
    public void testeSalvarListaVazia() throws IOException {
        String nomeArquivo = "filmes_vazio.json";
        FilmesJson.salvarFilmesEmJson(ListaFilmes.getFilmes(), nomeArquivo);
        String conteudo = Files.readString(new File(nomeArquivo).toPath());
        assertEquals("[]", conteudo.trim());
        new File(nomeArquivo).delete();
    }
}
