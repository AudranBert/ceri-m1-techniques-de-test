package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    private static Map<Integer, PokemonMetadata> index2meta;
    static {
        Map<Integer, PokemonMetadata> aMap = new HashMap<>();
        aMap.put(0, new PokemonMetadata(0,"Bulbizarre",126,126,90));
        aMap.put(133, new PokemonMetadata(133,"Aquali",186,168,260));
        //TODO : Gotta map them all !
        index2meta = UnmodifiableMap.unmodifiableMap(aMap);

    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Random rn = new Random();
        PokemonMetadata meta=index2meta.get(index);
        int sumRng=0;
        int rng=rn.nextInt(16);
        sumRng+=rng;
        int attack=meta.getAttack()+rng;
        rng=rn.nextInt(16);
        sumRng+=rng;
        int defense=meta.getDefense()+rng;
        rng=rn.nextInt(16);
        sumRng+=rng;
        int stamina=meta.getStamina()+rng;
        return new Pokemon(index, meta.getName(), attack, defense,stamina,cp,hp,dust,candy,(int) (sumRng*100)/45);
    }
}
