package fr.univavignon.pokedex.api;



import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Comparator;
import java.util.List;


public class IPokedexFactoryTest extends TestCase {



    IPokedexFactory mockPokedexFactory = mock(IPokedexFactory.class);
    Pokemon bulbizarre=new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);

    IPokemonMetadataProvider provider = mock(IPokemonMetadataProvider.class);
    IPokemonFactory factory = mock(IPokemonFactory.class);



    IPokedex pokedexTrue = mock(IPokedex.class);

    @BeforeEach
    public void setUp(){
        when(mockPokedexFactory.createPokedex(provider, factory)).thenReturn(pokedexTrue);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex=mockPokedexFactory.createPokedex(provider,factory);
        assertEquals(pokedexTrue,pokedex);
    }


}