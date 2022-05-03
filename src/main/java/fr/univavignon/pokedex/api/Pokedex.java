package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    ArrayList<Pokemon> listPokemon=new ArrayList<>();
    PokemonFactory pokemonFactory;
    PokemonMetadataProvider pokemonMetadataProvider;

    public Pokedex(PokemonFactory pokemonFactory, PokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    @Override
    public int size() {
        return listPokemon.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        listPokemon.add(pokemon);
        return listPokemon.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return listPokemon.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return listPokemon;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        ArrayList<Pokemon> sortedList= new ArrayList<>(listPokemon);
        sortedList.sort(order);
        return sortedList;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
