package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokedexFactoryTest {
    IPokedexFactory mockPokedexFactory = mock(IPokedexFactory.class);
    Pokemon bulbizarre=new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);

    IPokemonMetadataProvider provider = mock(IPokemonMetadataProvider.class);
    IPokemonFactory factory = mock(IPokemonFactory.class);



    IPokedex pokedex = new IPokedex() {
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
            return bulbizarre;
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

    @BeforeEach
    public void setup(){
        when(mockPokedexFactory.createPokedex(provider, factory)).thenReturn(pokedex);
    }

    @Test
    void createPokedexTest() {
        IPokedex pokedex=mockPokedexFactory.createPokedex(provider,factory);
        try {
            assertEquals(0,pokedex.getPokemon(0).getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
}