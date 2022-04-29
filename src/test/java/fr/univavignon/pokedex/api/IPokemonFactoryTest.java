package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest {

    IPokemonFactory mockPokemonFactory = mock(IPokemonFactory.class);
    Pokemon bulbizarre=new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    Pokemon aquali=new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);

    @BeforeEach
    public void setup(){
        when(mockPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(bulbizarre);
        when(mockPokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(aquali);
    }


    @Test
    public void getCpTestBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(0,pkm.getIndex());
    }

    @Test
    public void getHpTestBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(64,pkm.getHp());
    }

    @Test
    public void getDustTestBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(4000,pkm.getDust());
    }

    @Test
    public void getCandyTestBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(4,pkm.getCandy());
    }

    @Test
    public void getIvTestBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(56,pkm.getIv());
    }

    @Test
    public void getCpTestAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(133,pkm.getIndex());
    }

    @Test
    public void getHpTestAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(202,pkm.getHp());
    }

    @Test
    public void getDustTestAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(5000,pkm.getDust());
    }

    @Test
    public void getCandyTestAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(4,pkm.getCandy());
    }

    @Test
    public void getIvTestAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(100,pkm.getIv());
    }
}