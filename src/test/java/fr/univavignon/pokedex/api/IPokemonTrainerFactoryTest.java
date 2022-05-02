package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest extends TestCase {
    IPokemonTrainerFactory mockPokemonTrainerFactory=mock(IPokemonTrainerFactory.class);
    IPokedex pokedex = mock(IPokedex.class);

    IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

    PokemonTrainer pokemonTrainer=new PokemonTrainer("Test",Team.MYSTIC,pokedex);

    @BeforeEach
    public void setUp(){
        when(mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void testCreateTrainer() {
        assertEquals("Test",mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getName());
    }

    @Test
    public void testCreateTrainerGetTeam() {
        assertEquals(Team.MYSTIC,mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getTeam());
    }

}