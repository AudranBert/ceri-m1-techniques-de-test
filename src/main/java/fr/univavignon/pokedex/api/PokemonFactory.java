package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {



    private IPokemonMetadataProvider pokemonMetadataProvider;

    public PokemonFactory(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata meta = pokemonMetadataProvider.getPokemonMetadata(index);
            Random rn = new Random();
            int sumRng = 0;
            int rng = rn.nextInt(16);
            sumRng += rng;
            int attack = meta.getAttack() + rng;
            rng = rn.nextInt(16);
            sumRng += rng;
            int defense = meta.getDefense() + rng;
            rng = rn.nextInt(16);
            sumRng += rng;
            int stamina = meta.getStamina() + rng;
            return new Pokemon(index, meta.getName(), attack, defense, stamina, cp, hp, dust, candy, (sumRng * 100) / 45);
        } catch (PokedexException e) {
            e.printStackTrace();
        }
        return null;
    }
}
