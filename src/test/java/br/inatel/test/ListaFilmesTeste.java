package br.inatel.test;

import br.inatel.Filme;
import br.inatel.ListaFilmes;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.*;

public class ListaFilmesTeste {


    @Test // teste que verifica se a lista é criada quando se cria o primeiro filme
    public void testeListaFilmeExiste() {
        Filme filme = new Filme("titulo", 2002,"genero", "diretor");
        List<Filme> filmes = ListaFilmes.getFilmes();
        assertNotNull(filmes);
    }

    @Test // testa se a lista adiciona o filme automaticamente quando é criado
    public void testeListafilmecontem(){
        Filme filme = new Filme("titulo", 2002,"genero", "diretor");
        List<Filme> filmes = ListaFilmes.getFilmes();
        assertFalse(filmes.isEmpty());
    }

    @Test // teste se o filme adicionado na lista é igual ao filme criado
    public void testeListafilmeigual(){
        Filme filme = new Filme("titulo", 2002, "genero", "diretor");
        List<Filme> filmes = ListaFilmes.getFilmes();
        assertTrue(filmes.contains(filme));
    }

    @Test // testa se o titulo criado é igual ao adicionado na lista
    public void testeFilmeTitulo(){
        ListaFilmes.limparListaFilmes();
        Filme filme = new Filme("Matrix", 1999, "Ficção", "Wachowski");
        assertEquals("Matrix", ListaFilmes.getFilmes().get(0).getTitulo());
    }

    @Test // teste se quando é criado mais de 1 filme, o segundo é adicionado na lista de filmes
    public void testeListacontem2(){
        Filme filme = new Filme("Titulo", 2002, "genero", "diretor");
        Filme filme2 = new Filme("Titulo2", 2003, "genero2", "diretor2");

        assertTrue(ListaFilmes.getFilmes().contains(filme2));
    }

    @Test // testa se o tamanho da lista de filmes aumenta quando eu adiciono um filme
    public void testeTamanhoLista(){
        int tamanhoAntes = ListaFilmes.getFilmes().size();
        new Filme("Titulo", 2002, "genero", "diretor");
        int tamanhoDepois = ListaFilmes.getFilmes().size();

        assertEquals(tamanhoAntes + 1, tamanhoDepois);
    }

    @Test //testa se a lista nao é recriada quando eu crio um filme
    public void testeListaRecriada(){
        List<Filme> referenciaLista = ListaFilmes.getFilmes();
        new Filme("Titulo", 2002, "genero", "diretor");

        assertSame(referenciaLista, ListaFilmes.getFilmes());
    }

    @Test // testa se a lista inicia vazia
    public void testListaIniciaVazia() {
        ListaFilmes.limparListaFilmes();
        assertTrue(ListaFilmes.getFilmes().isEmpty());
    }

    @Test // testa se a lista de filmes nunca retorna null
    public void testGetFilmesNaoRetornaNull() {
        assertNotNull(ListaFilmes.getFilmes());
    }

    @Test // testa a ordem de insercao na lista
    public void testOrdemDeInsercao() {
        ListaFilmes.limparListaFilmes();
        new Filme("A", 2000, "Gen1", "Dir1");
        new Filme("B", 2001, "Gen2", "Dir2");

        assertEquals("A", ListaFilmes.getFilmes().get(0).getTitulo());
        assertEquals("B", ListaFilmes.getFilmes().get(1).getTitulo());
    }

    @Test
    public void testResetLimpaLista() {
        ListaFilmes.getFilmes().add(new Filme("A", 2000, "Gen1", "Dir1"));
        ListaFilmes.getFilmes().add(new Filme("B", 2001, "Gen2", "Dir2"));

        ListaFilmes.limparListaFilmes();

        assertTrue(ListaFilmes.getFilmes().isEmpty());
    }
}
