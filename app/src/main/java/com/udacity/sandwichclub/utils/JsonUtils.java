package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {


        Sandwich sandwich= null;
        //Describe all constants
        final  String KEYNAME = "name",
                  KEYMAINNAME = "mainname",
                  KEYALSOKNOWNAS="alsoknownas",
                  KEYPLACEOFORIGIN ="placeoforigin",
                  KEYDESCRIPTION= "description",
                   KEYIMAGEURL=    "image",
                   KEYINGREDIENTS = "ingredients";


        try{

            JSONObject rootJsonObject,nameObject;

            String mainname,placeOfOrigin,description,imageUrl;
            List<String>alsoKnownAsArray ,ingedientsArray;


            rootJsonObject = new JSONObject(json);

            nameObject = rootJsonObject.getJSONObject(KEYNAME);

            mainname= nameObject.optString(KEYMAINNAME);

            description = rootJsonObject.optString(KEYDESCRIPTION);

           alsoKnownAsArray = jsonArrayValuesToList(nameObject.getJSONArray(KEYALSOKNOWNAS));
            placeOfOrigin= rootJsonObject.optString(KEYPLACEOFORIGIN);
            imageUrl = rootJsonObject.optString(KEYIMAGEURL);

  ingedientsArray =jsonArrayValuesToList(nameObject.getJSONArray(KEYINGREDIENTS));

  sandwich = new Sandwich(mainname,alsoKnownAsArray,placeOfOrigin,description,imageUrl,ingedientsArray);

        }catch (JSONException e){
            e.printStackTrace();
        }

        return sandwich;
    }

 private  static List<String>jsonArrayValuesToList(JSONArray jsonArray){

        List<String>myList = new ArrayList<String>();


        for(int i= 0; i < jsonArray.length();i++){
            try {
                myList.add(jsonArray.getString(i));
            }catch (JSONException e) {
               e.printStackTrace();
            }

            }
        return  myList;

 }


}
