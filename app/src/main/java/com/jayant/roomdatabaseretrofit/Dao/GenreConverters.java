package com.jayant.roomdatabaseretrofit.Dao;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayant.roomdatabaseretrofit.Modal.Links;
import com.jayant.roomdatabaseretrofit.Modal.Urls;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class GenreConverters {

    @TypeConverter
    public static String fromUrls(Urls urls) {
        Gson gson = new Gson();
        String json = gson.toJson(urls);
        return json;
    }

    @TypeConverter
    public static String fromLinks(Links urls) {
        Gson gson = new Gson();
        String json = gson.toJson(urls);
        return json;
    }

    @TypeConverter
    public static ArrayList<String> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
