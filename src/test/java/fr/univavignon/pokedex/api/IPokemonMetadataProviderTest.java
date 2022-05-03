package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest  extends TestCase {

    //IPokemonMetadataProvider metaDataProvider = mock(IPokemonMetadataProvider.class);
    IPokemonMetadataProvider metaDataProvider = new PokemonMetadataProvider();

    PokemonMetadata bulbizarre=new PokemonMetadata(0,"Bulbizarre",126,126,90);
    PokemonMetadata aquali=new PokemonMetadata(133,"Aquali",186,168,260);


    @Before
    public void setUp(){
        /*
        try {
            when(metaDataProvider.getPokemonMetadata(0)).thenReturn(bulbizarre);
            when(metaDataProvider.getPokemonMetadata(133)).thenReturn(aquali);
        } catch (PokedexException e) {
            e.printStackTrace();
        }
        */
    }


    @Test
    public void testGetIndexBulbizarre() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(0);
            assertEquals(0,pm.getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNameBulbizarre() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(0);
            assertEquals("Bulbizarre",pm.getName());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAttackBulbizarre() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(0);
            assertEquals(126,pm.getAttack());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testGetDefenseBulbizarre() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(0);
            assertEquals(126,pm.getDefense());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void testGetStaminaBulbizarre() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(0);
            assertEquals(90,pm.getStamina());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetIndexAquali() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(133);
            assertEquals(133,pm.getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNameAquali() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(133);
            assertEquals("Aquali",pm.getName());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAttackAquali() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(133);
            assertEquals(186,pm.getAttack());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }


    @Test
    public  void testGetDefenseAquali() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(133);
            assertEquals(168,pm.getDefense());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testgetStaminaAquali() {
        try {
            PokemonMetadata pm= metaDataProvider.getPokemonMetadata(133);
            assertEquals(260,pm.getStamina());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
}