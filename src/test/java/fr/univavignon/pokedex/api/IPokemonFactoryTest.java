package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.mock;

public class IPokemonFactoryTest  extends TestCase {

    // IPokemonFactory mockPokemonFactory = mock(IPokemonFactory.class);
    IPokemonFactory pokemonFactory =new PokemonFactory(new PokemonMetadataProvider());
    // IPokemonFactory pokemonFactory =new RocketPokemonFactory();
    Pokemon bulbizarre=new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    Pokemon aquali=new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);

    @Before
    public void setUp(){
        /*
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(bulbizarre);
        when(pokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(aquali);
        */

    }

    @Test
    public void testCreatePokemonBadIndexMetadata() {
        assertNull(pokemonFactory.createPokemon(100,613,64,4000,4));
    }

    @Test
    public void testCreatePokemonNegativeIndexMetadata() {
        assertNull(pokemonFactory.createPokemon(-1,613,64,4000,4));
    }

    @Test
    public void testGetCpBulbizarre() {
        Pokemon pkm= pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(613,pkm.getCp());
    }

    @Test
    public void testGetHpBulbizarre() {
        Pokemon pkm= pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(64,pkm.getHp());
    }

    @Test
    public void testGetDustBulbizarre() {
        Pokemon pkm= pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(4000,pkm.getDust());
    }

    @Test
    public void testGetCandyBulbizarre() {
        Pokemon pkm= pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(4,pkm.getCandy());
    }

    @Test
    public void testGetIvBulbizarre() {
        Pokemon pkm= pokemonFactory.createPokemon(0,613,64,4000,4);
        assertTrue((pkm.getIv()>=0 && pkm.getIv()<=100));
        //assertEquals(56.0,pkm.getIv());
    }

    @Test
    public void testGetCpAquali() {
        Pokemon pkm= pokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(2729,pkm.getCp());
    }

    @Test
    public void TestGetHpAquali() {
        Pokemon pkm= pokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(202,pkm.getHp());
    }

    @Test
    public void testGetDustAquali() {
        Pokemon pkm= pokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(5000,pkm.getDust());
    }

    @Test
    public void testGetCandyAquali() {
        Pokemon pkm= pokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(4,pkm.getCandy());
    }

    @Test
    public void testGetIvAquali() {
        Pokemon pkm= pokemonFactory.createPokemon(133,2729,202,5000,4);
        assertTrue((pkm.getIv()>=0 && pkm.getIv()<=100));
        //assertEquals(100.0,pkm.getIv());
    }

    @Test
    public void testGetAttack(){
        Pokemon pkm= pokemonFactory.createPokemon(0,2729,202,5000,4);
        assertTrue((pkm.getAttack()>= bulbizarre.getAttack() && pkm.getAttack()<= bulbizarre.getAttack()+15));

    }
}