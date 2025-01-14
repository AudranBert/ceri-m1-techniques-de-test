package fr.univavignon.pokedex.api;

/**
 * Class PokemonTrainerFactory, implements IPokemonTrainerFactory
 * @author Audran
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokemonMetadataProvider iPokemonMetadataProvider = new PokemonMetadataProvider();
        IPokedex iPokedex = pokedexFactory.createPokedex(iPokemonMetadataProvider, new PokemonFactory(iPokemonMetadataProvider));
        return new PokemonTrainer(name, team, iPokedex);
    }
}
