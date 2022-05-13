package fr.univavignon.pokedex.api;

/**
 * Class PokedexFactory, implements IPokedexFactory
 * @author Audran
 */
public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(pokemonFactory, metadataProvider);
    }


}
