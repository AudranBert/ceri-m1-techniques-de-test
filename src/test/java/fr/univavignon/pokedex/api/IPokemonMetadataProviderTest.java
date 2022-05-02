package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonMetadataProviderTest   {

    IPokemonMetadataProvider mockMetaDataProvider = mock(IPokemonMetadataProvider.class);
    PokemonMetadata bulbizarre=new PokemonMetadata(0,"Bulbizarre",126,126,90);
    PokemonMetadata aquali=new PokemonMetadata(133,"Aquali",186,168,260);


    @BeforeEach
    public void setup(){
        try {
            when(mockMetaDataProvider.getPokemonMetadata(0)).thenReturn(bulbizarre);
            when(mockMetaDataProvider.getPokemonMetadata(133)).thenReturn(aquali);
        } catch (PokedexException e) {
            e.printStackTrace();
        }

    }


    @Test
    void getIndexTestBulbizarre() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(0);
            assertEquals(0,pm.getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getNameTestBulbizarre() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(0);
            assertEquals("Bulbizarre",pm.getName());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAttackTestBulbizarre() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(0);
            assertEquals(126,pm.getAttack());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }


    @Test
    void getDefenseTestBulbizarre() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(0);
            assertEquals(126,pm.getDefense());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getStaminaTestBulbizarre() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(0);
            assertEquals(90,pm.getStamina());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getIndexTestAquali() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(133);
            assertEquals(133,pm.getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getNameTestAquali() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(133);
            assertEquals("Aquali",pm.getName());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAttackTestAquali() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(133);
            assertEquals(186,pm.getAttack());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }


    @Test
    void getDefenseTestAquali() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(133);
            assertEquals(168,pm.getDefense());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getStaminaTestAquali() {
        try {
            PokemonMetadata pm=mockMetaDataProvider.getPokemonMetadata(133);
            assertEquals(260,pm.getStamina());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
}