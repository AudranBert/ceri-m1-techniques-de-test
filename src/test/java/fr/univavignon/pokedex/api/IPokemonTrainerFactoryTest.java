package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory mockPokemonTrainerFactory=mock(IPokemonTrainerFactory.class);
    IPokedex pokedex = mock(IPokedex.class);

    IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

    PokemonTrainer pokemonTrainer=new PokemonTrainer("Test",Team.MYSTIC,pokedex);

    @BeforeEach
    public void setup(){
        when(mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    void TestCreateTrainer() {
        assertEquals("Test",mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getName());
    }

    @Test
    void TestCreateTrainerGetTeam() {
        assertEquals(Team.MYSTIC,mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getTeam());
    }

}