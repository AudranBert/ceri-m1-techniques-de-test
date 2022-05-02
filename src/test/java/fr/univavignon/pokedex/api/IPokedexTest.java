package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IPokedexTest extends TestCase {


    IPokedex mockPokedex = mock(IPokedex.class);
    Pokemon bulbizarre=new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    Pokemon aquali=new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    List<Pokemon> pokemonList;

    @BeforeEach
    public void setUp(){
        pokemonList=new ArrayList<Pokemon>();
        when(mockPokedex.addPokemon(any(Pokemon.class))).then(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                pokemonList.add(invocationOnMock.getArgument(0));
                return pokemonList.size()-1;
            }
        });
        when(mockPokedex.size()).then(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return pokemonList.size();
            }
        });
        try {
            when(mockPokedex.getPokemon(any(Integer.class))).then(new Answer<Pokemon>() {
                @Override
                public Pokemon answer(InvocationOnMock invocationOnMock) throws Throwable {
                    int t=invocationOnMock.getArgument(0);
                    if (t<pokemonList.size() && t>=0){
                        return pokemonList.get(invocationOnMock.getArgument(0));
                    }
                    return null;
                }
            });
        } catch (PokedexException e) {
            e.printStackTrace();
        }
        when(mockPokedex.getPokemons()).then(new Answer<List<Pokemon>>() {
            @Override
            public List<Pokemon> answer(InvocationOnMock invocationOnMock) throws Throwable {
                return pokemonList;

            }
        });
        when(mockPokedex.getPokemons(any())).then(new Answer<List<Pokemon>>() {
            @Override
            public List<Pokemon> answer(InvocationOnMock invocationOnMock) throws Throwable {
                PokemonComparators comparators=PokemonComparators.INDEX;
                pokemonList.sort(comparators);
                return pokemonList;
            }
        });

    }


    @Test
    public void testAddPokemonBulbizarre(){
        int idx=mockPokedex.addPokemon(bulbizarre);
        assertEquals(0,idx);

    }

    @Test
    public void testSizeBulbizarre(){
        assertEquals(0,mockPokedex.size());
        mockPokedex.addPokemon(bulbizarre);
        assertEquals(1,mockPokedex.size());

    }


    @Test
    public void testGetPokemonShouldThrowException(){
        try {
            when(mockPokedex.getPokemon(-1)).thenThrow(PokedexException.class);
        } catch (PokedexException e) {
            e.printStackTrace();
        }

        assertThrows(PokedexException.class, () -> {
            mockPokedex.getPokemon(-1);
        });
    }

    @Test
    public void testGetPokemonShouldThrowException1(){
        try {
            when(mockPokedex.getPokemon(1)).thenThrow(new PokedexException("Blop"));
        } catch (PokedexException e) {
            e.printStackTrace();
        }

        assertThrows(PokedexException.class, () -> {
            mockPokedex.getPokemon(1);
        });

    }


    @Test
    public void testGetPokemonBulbizarre(){
        try {
            mockPokedex.addPokemon(bulbizarre);
            assertEquals(0,mockPokedex.getPokemon(0).getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemons(){
        mockPokedex.addPokemon(bulbizarre);
        List<Pokemon> list=mockPokedex.getPokemons();
        assertEquals(list.get(0).getIndex(),bulbizarre.getIndex());
    }


    @Test
    public void testGetPokemonsComparator(){
        PokemonComparators comparator=PokemonComparators.INDEX;
        mockPokedex.addPokemon(aquali);
        mockPokedex.addPokemon(bulbizarre);
        List<Pokemon> list=mockPokedex.getPokemons(comparator);
        assertEquals(list.get(0).getIndex(),bulbizarre.getIndex());
    }
}