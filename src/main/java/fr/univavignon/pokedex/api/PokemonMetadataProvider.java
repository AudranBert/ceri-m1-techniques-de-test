package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {


    private static Map<Integer, PokemonMetadata> index2meta;
    static {
        Map<Integer, PokemonMetadata> aMap = new HashMap<>();
        aMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        aMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        //TODO : Gotta map them all !
        index2meta = UnmodifiableMap.unmodifiableMap(aMap);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index2meta.get(index)!=null){
            return index2meta.get(index);
        } else {
            throw new PokedexException("pokemon inconnu");
        }
    }

}
