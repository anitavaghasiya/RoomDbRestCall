package com.jayant.roomdatabaseretrofit.Dao;

import android.content.ClipData;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayant.roomdatabaseretrofit.Modal.Links;
import com.jayant.roomdatabaseretrofit.Modal.TopicSubmissions;
import com.jayant.roomdatabaseretrofit.Modal.Urls;
import com.jayant.roomdatabaseretrofit.Modal.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ItemTypeConverter {

    private Gson gson = new Gson();

    @TypeConverter
    public List<Object> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Object>>() {}.getType();
        return gson.fromJson(value, listType);
    }

    @TypeConverter
    public String listToJson(List<Object> value){
        return new Gson().toJson(value);
    }

    @TypeConverter
    public String fromArrayList(ArrayList<Object> list) {
        return gson.toJson(list);
    }

    @TypeConverter
    public String fromUrlsToString(Urls urls) {
        return new Gson().toJson(urls);
    }

    @TypeConverter
    public Urls fromStringToUrls(String stringuser) {
        return new Gson().fromJson(stringuser, Urls.class);
    }

    @TypeConverter
    public String fromObjectToString(Object urls) {
        return new Gson().toJson(urls);
    }

    @TypeConverter
    public Object fromStringToObject(String stringuser) {
        return new Gson().fromJson(stringuser, Object.class);
    }

    @TypeConverter
    public String fromLinksToString(Links links) {
        return new Gson().toJson(links);
    }

    @TypeConverter
    public Links fromStringToLinks(String stringLinks) {
        return new Gson().fromJson(stringLinks, Links.class);
    }

    @TypeConverter
    public String fromUserToString(User links) {
        return new Gson().toJson(links);
    }

    @TypeConverter
    public User fromStringToUser(String stringLinks) {
        return new Gson().fromJson(stringLinks, User.class);
    }

    @TypeConverter
    public String fromTopicSubmissionsToString(TopicSubmissions links) {
        return new Gson().toJson(links);
    }

    @TypeConverter
    public TopicSubmissions fromStringToTopicSubmissions(String stringLinks) {
        return new Gson().fromJson(stringLinks, TopicSubmissions.class);
    }


}