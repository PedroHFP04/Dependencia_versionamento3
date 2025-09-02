package br.inatel.test;

import br.inatel.Filme;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FilmeTeste {

    @Test
    public void testeListaFilmeExiste() {
        Filme filme = new Filme("titulo", 2002,"genero", "diretor");
        List<Filme> filmes = Filme.getFilmes();
        assertNotNull(filmes);
    }
}
