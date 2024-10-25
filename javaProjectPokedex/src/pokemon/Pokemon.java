package pokemon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Arrays;

public class Pokemon {
    private String img;
    private Long candyCount;
    private String egg;
    private String candy;
    private String num;
    private String weight;
    private String[] type;
    private String[] weaknesses;
    private String name;
    private Double avgSpawns;
    private Evolution[] nextEvolution;

    public Pokemon(JSONObject json) {
        this.img = (String) json.get("img");
        this.candyCount = (Long) json.get("candy_count");
        this.egg = (String) json.get("egg");
        this.candy = (String) json.get("candy");
        this.num = (String) json.get("num");
        this.weight = (String) json.get("weight");
        this.type = jsonArrayToStringArray((JSONArray) json.get("type"));
        this.weaknesses = jsonArrayToStringArray((JSONArray) json.get("weaknesses"));
        this.name = (String) json.get("name");
        this.avgSpawns = (double) ((Number) json.get("avg_spawns")).intValue();
        this.nextEvolution = jsonArrayToEvolutionArray((JSONArray) json.get("next_evolution"));
    }

    private String[] jsonArrayToStringArray(JSONArray jsonArray) {
        String[] array = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            array[i] = (String) jsonArray.get(i);
        }
        return array;
    }

    private Evolution[] jsonArrayToEvolutionArray(JSONArray jsonArray) {
        if (!(jsonArray == null))
        {
            Evolution[] array = new Evolution[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);
                array[i] = new Evolution((String) obj.get("num"), (String) obj.get("name"));
            }
            return array;
        }
        Evolution[] array  = new Evolution[0];
        return array;
    }

    // Classe interne pour représenter l'évolution
    public class Evolution {
        private String num;
        private String name;

        public Evolution(String num, String name) {
            this.num = num;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Evolution{" +
                    "num='" + num + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "img='" + img + '\'' +
                ", candyCount=" + candyCount +
                ", egg='" + egg + '\'' +
                ", candy='" + candy + '\'' +
                ", num='" + num + '\'' +
                ", weight='" + weight + '\'' +
                ", type=" + Arrays.toString(type) +
                ", weaknesses=" + Arrays.toString(weaknesses) +
                ", name='" + name + '\'' +
                ", avgSpawns=" + avgSpawns +
                ", nextEvolution=" + Arrays.toString(nextEvolution) +
                '}';
    }
}
