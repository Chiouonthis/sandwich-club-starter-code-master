package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json){

        Sandwich sandwich = new Sandwich();

        if(json != null){

            String nameMain;
            List<String> nameAka;
            String origin;
            String description;
            String imageUrl;
            List<String> ingredients;

            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(json);

                JSONObject nameJSON = jsonObject.getJSONObject("name");
                nameMain = nameJSON.getString("mainName");
                sandwich.setMainName(nameMain);

                nameAka = new ArrayList<>();

                JSONArray sandwichAliases = nameJSON.getJSONArray("alsoKnownAs");
                if (sandwichAliases.length()>0){
                    for(int i = 0; i<sandwichAliases.length();i++){
                        nameAka.add(sandwichAliases.getString(i));
                    }
                }
                sandwich.setAlsoKnownAs(nameAka);

                origin = jsonObject.getString("placeOfOrigin");
                sandwich.setPlaceOfOrigin(origin);

                description = jsonObject.getString("description");
                sandwich.setDescription(description);

                imageUrl = jsonObject.getString("image");
                sandwich.setImage(imageUrl);

                JSONArray ingredientsJSON = jsonObject.getJSONArray("ingredients");

                ingredients = new ArrayList<>();

                for (int i = 0; i<ingredientsJSON.length();i++){
                    ingredients.add(ingredientsJSON.getString(i));
                }

                sandwich.setIngredients(ingredients);

                return sandwich;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return sandwich;
    }
}
