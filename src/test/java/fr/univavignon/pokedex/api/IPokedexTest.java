package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IPokedexTest extends TestCase {


    // IPokedex pokedex = mock(IPokedex.class);
    Pokedex pokedex =new Pokedex(new PokemonFactory(new PokemonMetadataProvider()),new PokemonMetadataProvider());
    Pokemon bulbizarre=new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    Pokemon aquali=new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    List<Pokemon> pokemonList;

    @Before
    public void setUp(){
        /*
        pokemonList=new ArrayList<Pokemon>();
        when(pokedex.addPokemon(any(Pokemon.class))).then(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                pokemonList.add(invocationOnMock.getArgument(0));
                return pokemonList.size()-1;
            }
        });
        when(pokedex.size()).then(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return pokemonList.size();
            }
        });
        try {
            when(pokedex.getPokemon(any(Integer.class))).then(new Answer<Pokemon>() {
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
        when(pokedex.getPokemons()).then(new Answer<List<Pokemon>>() {
            @Override
            public List<Pokemon> answer(InvocationOnMock invocationOnMock) throws Throwable {
                return pokemonList;

            }
        });
        when(pokedex.getPokemons(any())).then(new Answer<List<Pokemon>>() {
            @Override
            public List<Pokemon> answer(InvocationOnMock invocationOnMock) throws Throwable {
                PokemonComparators comparators=PokemonComparators.INDEX;
                pokemonList.sort(comparators);
                return pokemonList;
            }
        });
        */
    }


    @Test
    public void testAddPokemonBulbizarre(){
        int idx= pokedex.addPokemon(bulbizarre);
        assertEquals(0,idx);

    }

    @Test
    public void testSizeBulbizarre(){
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(bulbizarre);
        assertEquals(1, pokedex.size());

    }


    @Test
    public void testGetPokemonShouldThrowException(){
        /*
        try {
            when(pokedex.getPokemon(-1)).thenThrow(PokedexException.class);
        } catch (PokedexException e) {
            e.printStackTrace();
        }
         */

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-1);
        });
    }

    @Test
    public void testGetPokemonShouldThrowException1(){
        /*
        try {
            when(pokedex.getPokemon(1)).thenThrow(new PokedexException("Blop"));
        } catch (PokedexException e) {
            e.printStackTrace();
        }

         */

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(1);
        });

    }


    @Test
    public void testGetPokemonBulbizarre(){
        try {
            pokedex.addPokemon(bulbizarre);
            assertEquals(0, pokedex.getPokemon(0).getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemons(){
        pokedex.addPokemon(bulbizarre);
        List<Pokemon> list= pokedex.getPokemons();
        assertEquals(list.get(0).getIndex(),bulbizarre.getIndex());
    }


    @Test
    public void testGetPokemonsComparator(){
        PokemonComparators comparator=PokemonComparators.INDEX;
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);
        List<Pokemon> list= pokedex.getPokemons(comparator);
        assertEquals(list.get(0).getIndex(),bulbizarre.getIndex());
    }

    @Test
    public void testCreatePokemon(){
        Pokemon pkm=pokedex.createPokemon(0,613,64,4000,4);
        assertEquals(64,pkm.getHp());
    }

    @Test
    public void testGetPokemonMetadata(){
        try {
            PokemonMetadata pkm=pokedex.getPokemonMetadata(0);
            assertEquals(0,pkm.getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
}