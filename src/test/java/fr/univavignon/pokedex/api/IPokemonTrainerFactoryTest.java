package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest extends TestCase {
    // IPokemonTrainerFactory mockPokemonTrainerFactory=mock(IPokemonTrainerFactory.class);
    IPokemonTrainerFactory pokemonTrainerFactory =new PokemonTrainerFactory();

    // IPokedex pokedex = mock(IPokedex.class);
    IPokedex pokedex =new Pokedex(new PokemonFactory(new PokemonMetadataProvider()),new PokemonMetadataProvider());

    //IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    IPokedexFactory pokedexFactory = new PokedexFactory();

    PokemonTrainer pokemonTrainer=new PokemonTrainer("Test",Team.MYSTIC,pokedex);

    @Before
    public void setUp(){
        //when(pokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void testCreateTrainer() {
        assertEquals("Test", pokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getName());
    }

    @Test
    public void testCreateTrainerGetTeam() {
        assertEquals(Team.MYSTIC, pokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getTeam());
    }

    @Test
    public void testCreateTrainerGetPokedex() {
        assertNotNull(pokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getPokedex());
    }

}