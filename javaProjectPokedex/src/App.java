import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pokemon.Pokemon;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<Pokemon> pokemon = new ArrayList<>();
        int     numberOfPokemon;

        numberOfPokemon = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/data/pokedex.json"));
            
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray pokemonList = (JSONArray) jsonObject.get("pokemon");

            Iterator<JSONObject> iterator =  pokemonList.iterator();

            while (iterator.hasNext()) {

                JSONObject pokemonData = iterator.next();
                Pokemon newPokemon = new Pokemon(pokemonData);
                pokemon.add(newPokemon);
                numberOfPokemon++;
                System.out.println(newPokemon);
            }
            System.out.println("il y a " + numberOfPokemon + " pokemon dans la liste");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
