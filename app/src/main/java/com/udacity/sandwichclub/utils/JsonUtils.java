package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.List;

public class JsonUtils {

    //TODO complete the method body below
    public static Sandwich parseSandwichJson(String json){

        Sandwich sandwich = new Sandwich();

        if(json != null){

            String nameMain;
            List<String> nameAka;
            String origin;
            String description;
            String imageUrl;
            List<String> ingredients;

            //TODO get attributes/values from JSON and add to sandwich instance variable

            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(json);

                nameMain = jsonObject.getString("mainName");
                sandwich.setMainName(nameMain);

                //TODO nameAka

                origin = jsonObject.getString("placeOfOrigin");
                sandwich.setPlaceOfOrigin(origin);

                description = jsonObject.getString("description");
                sandwich.setDescription(description);

                imageUrl = jsonObject.getString("image");
                sandwich.setImage(imageUrl);

                //TODO ingredients


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return sandwich;

        }

        return sandwich;
    }
}
