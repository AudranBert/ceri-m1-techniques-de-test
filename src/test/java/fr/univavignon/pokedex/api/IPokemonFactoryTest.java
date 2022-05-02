package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest  extends TestCase {

    IPokemonFactory mockPokemonFactory = mock(IPokemonFactory.class);
    Pokemon bulbizarre=new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    Pokemon aquali=new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);

    @BeforeEach
    public void setUp(){
        when(mockPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(bulbizarre);
        when(mockPokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(aquali);
    }


    @Test
    public void testGetCpBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(0,pkm.getIndex());
    }

    @Test
    public void testGetHpBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(64,pkm.getHp());
    }

    @Test
    public void testGetDustBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(4000,pkm.getDust());
    }

    @Test
    public void testGetCandyBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(4,pkm.getCandy());
    }

    @Test
    public void testGetIvBulbizarre() {
        Pokemon pkm=mockPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(56.0,pkm.getIv());
    }

    @Test
    public void testGetCpAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(133,pkm.getIndex());
    }

    @Test
    public void TestGetHpAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(202,pkm.getHp());
    }

    @Test
    public void testGetDustAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(5000,pkm.getDust());
    }

    @Test
    public void testGetCandyAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(4,pkm.getCandy());
    }

    @Test
    public void testGetIvAquali() {
        Pokemon pkm=mockPokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(100.0,pkm.getIv());
    }
}