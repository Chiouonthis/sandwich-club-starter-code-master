package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static final String TAG = "JsonUtils.java class";

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
                Log.d(TAG,"Main name is " + nameMain);

                nameAka = new ArrayList<>();

                JSONArray sandwichAliases = nameJSON.getJSONArray("alsoKnownAs");
                Log.d(TAG,"JSONArray length is  " + sandwichAliases.length());
                if (sandwichAliases.length()>0){
                    for(int i = 0; i<sandwichAliases.length();i++){
                        nameAka.add(sandwichAliases.getString(i) + ", ");
                    }
                }
                Log.d(TAG,"nameAka is  " + nameAka);
                sandwich.setAlsoKnownAs(nameAka);

                origin = jsonObject.getString("placeOfOrigin");
                sandwich.setPlaceOfOrigin(origin);
                Log.d(TAG,"Origin is " + origin);

                description = jsonObject.getString("description");
                sandwich.setDescription(description);
                Log.d(TAG,"description is " + description);

                imageUrl = jsonObject.getString("image");
                sandwich.setImage(imageUrl);

                JSONArray ingredientsJSON = jsonObject.getJSONArray("ingredients");
                Log.d(TAG,"JSON array length is  " + ingredientsJSON.length());

                ingredients = new ArrayList<>();

                for (int i = 0; i<ingredientsJSON.length();i++){
                    ingredients.add(ingredientsJSON.getString(i));
                }
                Log.d(TAG,"Ingredients list is empty: " + ingredients.isEmpty());

                sandwich.setIngredients(ingredients);

                return sandwich;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return sandwich;
    }
}
