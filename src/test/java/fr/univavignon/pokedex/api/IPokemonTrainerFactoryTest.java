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
    IPokedex pokedex=new IPokedex() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public int addPokemon(Pokemon pokemon) {
            return 0;
        }

        @Override
        public Pokemon getPokemon(int id) throws PokedexException {
            return null;
        }

        @Override
        public List<Pokemon> getPokemons() {
            return null;
        }

        @Override
        public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
            return null;
        }

        @Override
        public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
            return null;
        }

        @Override
        public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
            return null;
        }
    };
    IPokedexFactory pokedexFactory=new IPokedexFactory() {
        @Override
        public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
            return null;
        }
    };
    PokemonTrainer pokemonTrainer=new PokemonTrainer("Test",Team.MYSTIC,pokedex);

    @BeforeEach
    public void setup(){
        when(mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    void createTrainerTest() {
        assertEquals("Test",mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getName());
    }

    @Test
    void createTrainerTestGetTeam() {
        assertEquals(Team.MYSTIC,mockPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,pokedexFactory).getTeam());
    }

}