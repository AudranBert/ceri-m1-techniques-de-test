package fr.univavignon.pokedex.api;



import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IPokedexFactoryTest extends TestCase {



    // IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    PokedexFactory pokedexFactory = new PokedexFactory();
    Pokemon bulbizarre=new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);

    //IPokemonMetadataProvider provider = mock(IPokemonMetadataProvider.class);
    IPokemonMetadataProvider provider = new PokemonMetadataProvider();

    // IPokemonFactory factory = mock(IPokemonFactory.class);
    IPokemonFactory factory = new PokemonFactory(new PokemonMetadataProvider());

    //IPokedex pokedexTrue = mock(IPokedex.class);
    IPokedex pokedexTrue = new Pokedex( factory, provider);

    @BeforeEach
    public void setUp(){
        //when(pokedexFactory.createPokedex(provider, factory)).thenReturn(pokedexTrue);
    }

    @Test
    public void testCreatePokedex() {
        assertNotNull(pokedexFactory.createPokedex(provider,factory));
    }


}