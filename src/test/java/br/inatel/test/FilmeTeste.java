package br.inatel.test;

import br.inatel.Filme;
import br.inatel.FilmesJson;
import br.inatel.ListaFilmes;
import org.junit.Test;

import java.io.File;
import java.util.List;
import static org.junit.Assert.*;

public class FilmeTeste {

    @Test
    public void testeFilmesIguais() {
        Filme f1 = new Filme("titulo", 2002, "genero", "diretor");
        Filme f2 = new Filme("titulo", 2002, "genero", "diretor");
        assertNotSame(f1, f2);
    }
    @Test
    public void testeAno() {
        Filme filme = new Filme("titulo", 2000, "genero", "diretor");
        assertEquals(2000, filme.getAno());
    }
    @Test
    public void testeGenero() {
        Filme filme = new Filme("titulo", 2000, "genero", "diretor");
        assertEquals("genero", filme.getGenero());
    }
    @Test
    public void testeDiretor() {
        Filme filme = new Filme("titulo", 2000, "genero", "diretor");
        assertEquals("diretor", filme.getDiretor());
    }
    @Test
    public void testeTitulo() {
        Filme filme = new Filme("titulo", 2000, "genero", "diretor");
        assertEquals("titulo", filme.getTitulo());
    }


}
